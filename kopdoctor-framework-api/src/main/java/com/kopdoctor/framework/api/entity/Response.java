package com.kopdoctor.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
        return Response.<Void>builder().build().setHead(ResponseHead.builder().build().success(message));
    }

    public static Response<Void> success() {
        return Response.<Void>builder().build().setHead(ResponseHead.builder().build().success());
    }

    public static <T> Response<T> success(T body) {
        return Response.<T>builder().build().setHead(ResponseHead.builder().build().success()).setBody(body);
    }

    public static <T> Response<T> success(String message, T body) {
        return Response.<T>builder().build().setHead(ResponseHead.builder().build().success(message)).setBody(body);
    }

    public static Response<Void> errorMessage(String message) {
        return Response.<Void>builder().build().setHead(ResponseHead.builder().build().failure(message));
    }

    public static Response<Void> error() {
        return Response.<Void>builder().build().setHead(ResponseHead.builder().build().failure());
    }

    public static Response<RestCode> error(RestCode restCode) {
        return Response.<RestCode>builder().build().setHead(ResponseHead.builder().build().failure(restCode));
    }

    public static <T> Response<T> error(T body) {
        return Response.<T>builder().build().setHead(ResponseHead.builder().build().failure()).setBody(body);
    }

    public static Response<Void> error(String code, String message) {
        return Response.<Void>builder().build().setHead(ResponseHead.builder().build().failure(code, message));
    }

    public static <T> Response<T> error(String code, String message, T body) {
        return Response.<T>builder().build().setHead(ResponseHead.builder().build().failure(code, message)).setBody(body);
    }

}
