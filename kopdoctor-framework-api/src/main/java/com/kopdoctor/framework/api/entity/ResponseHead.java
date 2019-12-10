package com.kopdoctor.framework.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseHead {

    private static final String SUCCESS_CODE = "0";

    private static final String SUCCESS_MESSAGE = "Success";

    private static final String FAILURE_CODE = "-1";

    private static final String FAILURE_MESSAGE = "Failure";

    private String requestId;

    private String code;

    private String message;

    private Long timestamp;

    private Long taketime;

    private String encoding;

    public ResponseHead success() {
        return this.success(SUCCESS_MESSAGE);
    }

    public ResponseHead success(String message) {
        return this.success(SUCCESS_CODE, message);
    }

    public ResponseHead success(String code, String message) {
        return ResponseHead.builder().build().setCode(code).setMessage(message).setTimestamp(System.currentTimeMillis());
    }

    public ResponseHead failure() {
        return this.failure(FAILURE_MESSAGE);
    }

    public ResponseHead failure(String message) {
        return this.failure(FAILURE_CODE, message);
    }

    public ResponseHead failure(String code, String message) {
        return ResponseHead.builder().build().setCode(code).setMessage(message).setTimestamp(System.currentTimeMillis());
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean isError() {
        return !isSuccess();
    }

}
