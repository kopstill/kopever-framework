package com.kopdoctor.framework.common.entity;

import lombok.Getter;
import lombok.Setter;

public enum ErrorCode {

    SUCCESS("0", "success"),
    FAILURE("-1", "failure"),
    SYSTEM_EXCEPTION("1", "system exception"),
    INTERNAL_EXCEPTION("2", "internal exception"),
    EXTERNAL_EXCEPTION("3", "external exception"),
    REMOTE_EXCEPTION("4", "remote exception"),
    ;

    ErrorCode(String code, String message) {
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
