package com.yuly.framework.common.util.json;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.micrometer.common.util.StringUtils;
import lombok.SneakyThrows;

import java.util.Map;

/**
 * JSON 工具类
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
public class JsonUtils {

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // 解决 LocalDateTime 的序列化问题
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OBJECT_MAPPER.registerModules(new JavaTimeModule());
    }

    /**
     * 初始化：统一使用 Spring Boot 个性化配置的 ObjectMapper
     */
    public static void init(ObjectMapper objectMapper) {
        OBJECT_MAPPER = objectMapper;
    }

    /**
     * 将对象转换为 JSON 字符串
     *
     * @param obj 对象
     * @return JSON 字符串
     */
    @SneakyThrows
    public static String toJsonString(Object obj) {
        return OBJECT_MAPPER.writeValueAsString(obj);

    }

    /**
     * 将 JSON 字符串转换为对象
     *
     * @param jsonStr JSON 字符串
     * @param clazz   对象类型
     * @return 对象
     */
    @SneakyThrows
    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }

        return OBJECT_MAPPER.readValue(jsonStr, clazz);
    }

    /**
     * 将 JSON 字符串转换为 Map
     *
     * @param jsonStr    JSON 字符串
     * @param keyClass   key 的类型
     * @param valueClass value 的类型
     * @return Map
     */
    public static <K, V> Map<K, V> parseMap(String jsonStr, Class<K> keyClass, Class<V> valueClass) throws Exception {
        // 创建 TypeReference，指定泛型类型
        TypeReference<Map<K, V>> typeRef = new TypeReference<Map<K, V>>() {
        };

        // 将 JSON 字符串转换为 Map
        return OBJECT_MAPPER.readValue(jsonStr, OBJECT_MAPPER.getTypeFactory().constructMapType(Map.class, keyClass, valueClass));
    }
}
