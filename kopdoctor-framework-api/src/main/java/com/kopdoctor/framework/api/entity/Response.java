package com.kopdoctor.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kopdoctor.framework.common.entity.IRestCode;
import com.kopdoctor.framework.common.entity.RestCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private ResponseHead head;

    private T body;

    public static Response<Void> success() {
        return success(RestCode.SUCCESS);
    }

    public static Response<Void> success(IRestCode restCode) {
        return success(restCode, null);
    }

    public static <T> Response<T> success(T body) {
        return success(RestCode.SUCCESS, body);
    }

    public static <T> Response<T> success(IRestCode restCode, T body) {
        return success(restCode.getCode(), restCode.getMessage(), body);
    }

    public static Response<Void> success(String code, String message) {
        return success(code, message, null);
    }

    public static <T> Response<T> success(String code, String message, T body) {
        return Response.<T>builder().build().setHead(ResponseHead.success(code, message)).setBody(body);
    }

    public static Response<Void> successCode(String code) {
        return successCode(code, null);
    }

    public static <T> Response<T> successCode(String code, T body) {
        return success(code, RestCode.SUCCESS.getMessage(), body);
    }

    public static Response<Void> successMessage(String message) {
        return successMessage(message, null);
    }

    public static <T> Response<T> successMessage(String message, T body) {
        return success(RestCode.SUCCESS.getCode(), message, body);
    }

    public static Response<Void> error() {
        return error(RestCode.FAILURE);
    }

    public static Response<Void> error(IRestCode restCode) {
        return error(restCode.getCode(), restCode.getMessage());
    }

    public static <T> Response<T> error(T body) {
        return error(RestCode.FAILURE, body);
    }

    public static <T> Response<T> error(IRestCode restCode, T body) {
        return error(restCode.getCode(), restCode.getMessage(), body);
    }

    public static Response<Void> error(String code, String message) {
        return error(code, message, null);
    }

    public static <T> Response<T> error(String code, String message, T body) {
        return Response.<T>builder().build().setHead(ResponseHead.failure(code, message)).setBody(body);
    }

    public static Response<Void> errorCode(String code) {
        return errorCode(code, null);
    }

    public static <T> Response<T> errorCode(String code, T body) {
        return error(code, RestCode.FAILURE.getMessage(), body);
    }

    public static Response<Void> errorMessage(String message) {
        return errorMessage(message, null);
    }

    public static <T> Response<T> errorMessage(String message, T body) {
        return error(RestCode.FAILURE.getCode(), message, body);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.head.isSuccess();
    }

    @JsonIgnore
    public boolean isError() {
        return this.head.isError();
    }

}
