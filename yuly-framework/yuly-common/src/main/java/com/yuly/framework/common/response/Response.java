package com.yuly.framework.common.response;

import com.yuly.framework.common.exception.BizException;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应工具类
 *
 * @author 于立洋
 * @version 1.0
 * @since 2025/4/17
 **/
@Data
@Accessors(chain = true)
public class Response<T> implements Serializable {

    /**
     * 响应码，默认为 200
     */
    private String code = "200";

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 是否成功，默认为 true
     */
    private boolean success = true;

    /**
     * 响应数据
     */
    private T data;


    // =================================== 成功响应 ===================================

    /**
     * 构建无数据的成功响应
     *
     * @return 响应实例
     */
    public static <T> Response<T> success() {
        return returnSuccess(ResponseCode.SUCCESS, null);
    }

    /**
     * 构建带数据的成功响应
     *
     * @param data 要返回的业务数据
     * @return 响应实例
     */
    public static <T> Response<T> success(T data) {
        return returnSuccess(ResponseCode.SUCCESS, data);
    }

    /**
     * 构建无数据的成功响应
     *
     * @param responseCode 响应码定义
     * @return 响应实例
     */
    public static <T> Response<T> success(ResponseCodeDefinition responseCode) {
        return returnSuccess(responseCode, null);
    }

    /**
     * 构建带数据的成功响应
     *
     * @param responseCode 响应码定义
     * @param data         要返回的业务数据
     * @return 响应实例
     */
    public static <T> Response<T> success(ResponseCodeDefinition responseCode, T data) {
        return returnSuccess(responseCode, data);
    }

    /**
     * 构建成功响应
     *
     * @param responseCode 响应码定义
     * @param data         要返回的业务数据
     * @return 响应实例
     */
    private static <T> Response<T> returnSuccess(ResponseCodeDefinition responseCode, T data) {
        return new Response<T>()
                .setCode(responseCode.getCode())
                .setMsg(responseCode.getMsg())
                .setData(data);
    }


    // =================================== 失败响应 ===================================

    /**
     * 构造无数据的失败响应
     *
     * @return 响应实例
     */
    public static <T> Response<T> fail() {
        return returnFail(ResponseCode.INTERNAL_ERROR, null);
    }

    /**
     * 构造无数据的失败响应
     *
     * @param responseCode 响应码定义
     * @return 响应实例
     */
    public static <T> Response<T> fail(ResponseCodeDefinition responseCode) {
        return returnFail(responseCode, null);
    }

    /**
     * 构造带数据的失败响应
     *
     * @param responseCode 响应码定义
     * @param data         失败时返回的业务数据
     * @return 响应实例
     */
    public static <T> Response<T> fail(ResponseCodeDefinition responseCode, T data) {
        return returnFail(responseCode, data);
    }

    /**
     * 构造无数据的失败响应
     *
     * @param bizException 业务异常
     * @return 响应实例
     */
    public static <T> Response<T> fail(BizException bizException) {
        return returnFail(bizException.getErrorCode(), bizException.getErrorMessage(), null);
    }

    /**
     * 构造无数据的失败响应
     *
     * @param errorCode    异常码
     * @param errorMessage 异常信息
     * @return 响应实例
     */
    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        return returnFail(errorCode, errorMessage, null);
    }

    /**
     * 构造带数据的失败响应
     *
     * @param errorCode    异常码
     * @param errorMessage 异常信息
     * @param data         失败时返回的业务数据
     * @return 响应实例
     */
    public static <T> Response<T> fail(String errorCode, String errorMessage, T data) {
        return returnFail(errorCode, errorMessage, data);
    }

    /**
     * 构建失败响应
     *
     * @param responseCode 响应码定义
     * @param data         失败时返回的业务数据
     * @return 响应实例
     */
    private static <T> Response<T> returnFail(ResponseCodeDefinition responseCode, T data) {
        return new Response<T>().
                setCode(responseCode.getCode())
                .setMsg(responseCode.getMsg())
                .setSuccess(false)
                .setData(data);
    }

    /**
     * 构建失败响应
     *
     * @param errorCode    异常码
     * @param errorMessage 异常信息
     * @param data         失败时返回的业务数据
     * @return 响应实例
     */
    private static <T> Response<T> returnFail(String errorCode, String errorMessage, T data) {
        return new Response<T>()
                .setCode(errorCode)
                .setMsg(errorMessage)
                .setSuccess(false)
                .setData(data);
    }
}
