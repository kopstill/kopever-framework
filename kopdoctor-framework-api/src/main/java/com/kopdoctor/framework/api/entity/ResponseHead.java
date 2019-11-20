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

    public static ResponseHead success() {
        return ResponseHead.builder().build().code(SUCCESS_CODE).message(SUCCESS_MESSAGE).timestamp(System.currentTimeMillis());
    }

    public static ResponseHead failure() {
        return ResponseHead.builder().build().code(FAILURE_CODE).message(FAILURE_MESSAGE).timestamp(System.currentTimeMillis());
    }

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }

    public boolean isError() {
        return !isSuccess();
    }

}
