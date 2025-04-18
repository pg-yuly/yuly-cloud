package com.yuly.framework.common.exception;

import com.yuly.framework.common.response.ResponseCodeDefinition;
import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常类
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
@Getter
@Setter
public class BizException extends RuntimeException {

    /**
     * 异常码
     */
    private String errorCode;

    /**
     * 异常信息
     */
    private String errorMessage;

    /**
     * 构造方法
     *
     * @param responseCodeDefinition 响应码定义
     */
    public BizException(ResponseCodeDefinition responseCodeDefinition) {
        this.errorCode = responseCodeDefinition.getCode();
        this.errorMessage = responseCodeDefinition.getMsg();
    }
}
