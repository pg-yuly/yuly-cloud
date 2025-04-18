package com.yuly.framework.biz.context.interceptor;

import com.yuly.framework.biz.context.holder.LoginUserContextHolder;
import com.yuly.framework.common.constant.GlobalConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * Feign 请求拦截器
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/18
 **/
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取当前上下文中的用户 ID
        Long userId = LoginUserContextHolder.getUserId();

        // 若不为空，则添加到请求头中
        if (Objects.nonNull(userId)) {
            requestTemplate.header(GlobalConstants.USER_ID, String.valueOf(userId));
            log.info("########## feign 请求设置请求头 userId: {}", userId);
        }
    }
}
