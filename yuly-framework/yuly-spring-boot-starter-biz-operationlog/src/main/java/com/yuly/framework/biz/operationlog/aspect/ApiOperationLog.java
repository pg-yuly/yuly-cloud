package com.yuly.framework.biz.operationlog.aspect;

import java.lang.annotation.*;

/**
 * API 操作日志注解
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {

    /**
     * 描述
     *
     * @return 描述信息
     */
    String description() default "";
}
