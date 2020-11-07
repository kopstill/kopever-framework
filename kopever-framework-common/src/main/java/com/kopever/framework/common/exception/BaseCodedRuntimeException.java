package com.kopever.framework.common.exception;

import com.kopever.framework.common.entity.RestCode;
import lombok.Getter;

public abstract class BaseCodedRuntimeException extends BaseRuntimeException {

    @Getter
    private final String code;

    public BaseCodedRuntimeException(String message) {
        this(RestCode.SYSTEM_RUNTIME_EXCEPTION.getCode(), message);
    }

    public BaseCodedRuntimeException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BaseCodedRuntimeException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

}
