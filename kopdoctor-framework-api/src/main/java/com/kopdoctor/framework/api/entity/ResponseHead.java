package com.kopdoctor.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kopdoctor.framework.common.entity.IRestCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

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

    private Boolean success;

    private Boolean error;

    public static ResponseHead success(IRestCode restCode) {
        return success(restCode.getCode(), restCode.getMessage());
    }

    public static ResponseHead success(String code, String message) {
        return ResponseHead.builder().build().
                setCode(code).
                setMessage(message).
                setTimestamp(Instant.now().toEpochMilli()).
                setSuccess(true).
                setError(false);
    }

    public static ResponseHead failure(IRestCode restCode) {
        return failure(restCode.getCode(), restCode.getMessage());
    }

    public static ResponseHead failure(String code, String message) {
        return ResponseHead.builder().build().
                setCode(code).
                setMessage(message).
                setTimestamp(Instant.now().toEpochMilli()).
                setSuccess(false).
                setError(true);
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isError() {
        return error;
    }

}
