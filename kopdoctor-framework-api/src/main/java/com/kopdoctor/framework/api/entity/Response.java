package com.kopdoctor.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    public static <T> Response<T> success(String message) {
        return Response.<T>builder().build().head(ResponseHead.builder().build().message(message));
    }

    public static <T> Response<T> success(T body) {
        return Response.<T>builder().build().head(ResponseHead.builder().build()).body(body);
    }

    public static <T> Response<T> success(String message, T body) {
        return Response.<T>builder().build().head(ResponseHead.builder().build().message(message)).body(body);
    }

    public static <T> Response<T> error() {
        return Response.<T>builder().build().head(ResponseHead.failure());
    }

    public static <T> Response<T> error(String code, String message) {
        return Response.<T>builder().build().head(ResponseHead.builder().build().code(code).message(message));
    }

    public static <T> Response<T> error(String code, String message, T body) {
        return Response.<T>builder().build().head(ResponseHead.builder().build().code(code).message(message)).body(body);
    }

}
