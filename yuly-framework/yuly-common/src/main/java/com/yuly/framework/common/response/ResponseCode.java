package com.yuly.framework.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一响应状态码定义
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
@Getter
@AllArgsConstructor
public enum ResponseCode implements ResponseCodeDefinition{

    /* 成功类状态码 */
    SUCCESS("200", "请求成功"),
    CREATED("201", "资源创建成功"),
    ACCEPTED("202", "请求已接受"),

    /* 客户端错误类 */
    BAD_REQUEST("400", "请求参数错误"),
    UNAUTHORIZED("401", "未授权访问"),
    FORBIDDEN("403", "禁止访问"),
    NOT_FOUND("404", "资源未找到"),
    METHOD_NOT_ALLOWED("405", "请求方法不允许"),

    /* 服务端错误类 */
    INTERNAL_ERROR("500", "服务器内部错误"),
    SERVICE_UNAVAILABLE("503", "服务不可用");

    private final String code;
    private final String msg;
}
