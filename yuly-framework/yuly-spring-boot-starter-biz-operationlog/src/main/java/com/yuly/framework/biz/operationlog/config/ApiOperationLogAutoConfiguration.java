package com.yuly.framework.biz.operationlog.config;

import com.yuly.framework.biz.operationlog.aspect.ApiOperationLogAspect;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * ApiOperationLogAutoConfiguration 自动配置类
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
@AutoConfiguration
public class ApiOperationLogAutoConfiguration {

    @Bean
    public ApiOperationLogAspect apiOperationLogAspect() {
        return new ApiOperationLogAspect();
    }
}
