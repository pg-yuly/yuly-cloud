package com.yuly.framework.biz.context.holder;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.yuly.framework.common.constant.GlobalConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 登录用户上下文
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/18
 **/
public class LoginUserContextHolder {

    /**
     * 初始化一个 ThreadLocal 变量
     */
    private static final ThreadLocal<Map<String, Object>> LOGIN_USER_CONTEXT_THREAD_LOCAL
            = TransmittableThreadLocal.withInitial(HashMap::new);

    /**
     * 设置用户 ID
     *
     * @param value 用户 ID
     */
    public static void setUserId(Object value) {
        LOGIN_USER_CONTEXT_THREAD_LOCAL.get().put(GlobalConstants.USER_ID, value);
    }

    /**
     * 获取用户 ID
     *
     * @return 用户 ID
     */
    public static Long getUserId() {
        Object value = LOGIN_USER_CONTEXT_THREAD_LOCAL.get().get(GlobalConstants.USER_ID);
        if (Objects.isNull(value)) {
            return null;
        }
        return Long.valueOf(value.toString());
    }

    /**
     * 删除 ThreadLocal
     */
    public static void remove() {
        LOGIN_USER_CONTEXT_THREAD_LOCAL.remove();
    }
}
