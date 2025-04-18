package com.yuly.framework.biz.context.config;

import com.yuly.framework.biz.context.filter.HeaderUserId2ContextFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * ContextAutoConfiguration 自动配置类
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/18
 **/
@AutoConfiguration
public class ContextAutoConfiguration {

    @Bean
    public FilterRegistrationBean<HeaderUserId2ContextFilter> filterFilterRegistrationBean() {
        HeaderUserId2ContextFilter filter = new HeaderUserId2ContextFilter();
        return new FilterRegistrationBean<>(filter);
    }
}
