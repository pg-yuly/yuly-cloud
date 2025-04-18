package com.yuly.framework.common.response;

/**
 * 响应码定义
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
public interface ResponseCodeDefinition {

    /**
     * 获取响应码
     *
     * @return 响应码
     */
    String getCode();

    /**
     * 获取响应消息
     *
     * @return 响应消息
     */
    String getMsg();
}
