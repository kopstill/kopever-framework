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

    public static Response<Void> successMessage(String message) {
        return Response.<Void>builder().build().setHead(ResponseHead.success(message));
    }

    public static Response<Void> success() {
        return successMessage(RestCode.SUCCESS.getMessage());
    }

    public static <T> Response<T> success(IRestCode restCode) {
        return success(restCode, null);
    }

    public static <T> Response<T> success(T body) {
        return success(RestCode.SUCCESS.getMessage(), body);
    }

    public static <T> Response<T> success(IRestCode restCode, T body) {
        return success(restCode.getMessage(), body);
    }

    public static <T> Response<T> success(String message, T body) {
        return Response.<T>builder().build().setHead(ResponseHead.success(message)).setBody(body);
    }

    public static Response<Void> error() {
        return error(RestCode.FAILURE);
    }

    public static Response<Void> error(IRestCode restCode) {
        return error(restCode.getCode(), restCode.getMessage());
    }

    public static Response<Void> errorCode(String code) {
        return error(code, RestCode.FAILURE.getMessage());
    }

    public static Response<Void> errorMessage(String message) {
        return error(RestCode.FAILURE.getCode(), message);
    }

    public static Response<Void> error(String code, String message) {
        return Response.<Void>builder().build().setHead(ResponseHead.failure(code, message));
    }

    public static <T> Response<T> error(T body) {
        return error(RestCode.FAILURE, body);
    }

    public static <T> Response<T> errorCode(String code, T body) {
        return error(code, RestCode.FAILURE.getMessage(), body);
    }

    public static <T> Response<T> errorMessage(String message, T body) {
        return error(RestCode.FAILURE.getCode(), message, body);
    }

    public static <T> Response<T> error(IRestCode restCode, T body) {
        return error(restCode.getCode(), restCode.getMessage(), body);
    }

    public static <T> Response<T> error(String code, String message, T body) {
        return Response.<T>builder().build().setHead(ResponseHead.failure(code, message)).setBody(body);
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
