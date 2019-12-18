package com.kopdoctor.framework.common.entity;

import lombok.Getter;
import lombok.Setter;

public enum RestCode implements IRestCode {

    SUCCESS("0", "success"),
    FAILURE("-1", "failure"),
    SYSTEM_EXCEPTION("1", "system exception"),
    SYSTEM_RUNTIME_EXCEPTION("2", "system runtime exception"),
    REQUEST_PARAMS_EXCEPTION("3", "request params exception"),
    REQUEST_INVALID_EXCEPTION("4", "request invalid exception"),
    ;

    RestCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String message;

}
