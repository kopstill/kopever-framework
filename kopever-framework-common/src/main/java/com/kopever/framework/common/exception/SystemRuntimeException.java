package com.kopever.framework.common.exception;

import com.kopever.framework.common.entity.RestCode;

public class SystemRuntimeException extends BaseCodedRuntimeException {

    public SystemRuntimeException(String message) {
        this(RestCode.SYSTEM_RUNTIME_EXCEPTION.getCode(), message);
    }

    private SystemRuntimeException(String code, String message) {
        super(code, message);
    }

}
