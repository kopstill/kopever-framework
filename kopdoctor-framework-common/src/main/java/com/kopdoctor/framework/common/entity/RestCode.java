package com.kopdoctor.framework.common.entity;

import lombok.Getter;
import lombok.Setter;

public enum RestCode {

    SUCCESS("0", "success"),
    FAILURE("-1", "failure"),
    SYSTEM_EXCEPTION("1", "system exception"),
    SYSTEM_RUNTIME_EXCEPTION("2", "system runtime exception"),
    INTERNAL_EXCEPTION("3", "internal exception"),
    EXTERNAL_EXCEPTION("4", "external exception"),
    REMOTE_EXCEPTION("5", "remote exception"),
    REQUEST_EXCEPTION("6", "request exception"),
    RESPONSE_EXCEPTION("7", "response exception"),
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
