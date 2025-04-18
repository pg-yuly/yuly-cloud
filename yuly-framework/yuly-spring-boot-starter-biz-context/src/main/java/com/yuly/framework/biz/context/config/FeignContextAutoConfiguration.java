package com.yuly.framework.biz.context.config;

import com.yuly.framework.biz.context.interceptor.FeignRequestInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Feign 请求拦截器自动配置
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/18
 **/
@AutoConfiguration
public class FeignContextAutoConfiguration {

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
