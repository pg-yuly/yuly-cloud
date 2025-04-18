package com.yuly.framework.common.util.date;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Date 工具类
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
public class DateUtils {

    /**
     * LocalDateTime 转时间戳
     *
     * @param localDateTime LocalDateTime
     * @return 时间戳格式
     */
    public static long localDateTime2Timestamp(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }
}
