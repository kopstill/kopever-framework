package com.kopdoctor.framework.api.entity;

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
public class ResponseHead {

    private String requestId;

    private String code;

    private String message;

    private Long timestamp;

    private Long taketime;

    private String encoding;

    public static ResponseHead success() {
        return success(RestCode.SUCCESS.getMessage());
    }

    public static ResponseHead success(String message) {
        return ResponseHead.builder().build().setCode(RestCode.SUCCESS.getCode()).setMessage(message).setTimestamp(System.currentTimeMillis());
    }

    public static ResponseHead failure() {
        return failure(RestCode.FAILURE);
    }

    public static ResponseHead failure(IRestCode restCode) {
        return failure(restCode.getCode(), restCode.getMessage());
    }

    public static ResponseHead failure(String message) {
        return failure(RestCode.FAILURE.getCode(), message);
    }

    public static ResponseHead failure(String code, String message) {
        return ResponseHead.builder().build().setCode(code).setMessage(message).setTimestamp(System.currentTimeMillis());
    }

    public boolean isSuccess() {
        return RestCode.SUCCESS.getCode().equals(code);
    }

    public boolean isError() {
        return !isSuccess();
    }

}
