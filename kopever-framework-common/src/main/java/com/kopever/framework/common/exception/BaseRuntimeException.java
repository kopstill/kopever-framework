package com.kopever.framework.common.exception;

import com.kopever.framework.common.entity.RestCode;
import lombok.Getter;

public abstract class BaseRuntimeException extends RuntimeException implements IBaseRuntimeException {

    @Getter
    private final String message;

    @Override
    public String getLocalizedMessage() {
        return message;
    }

    public BaseRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    public BaseRuntimeException(Throwable throwable) {
        super(throwable);
        this.message = RestCode.SYSTEM_RUNTIME_EXCEPTION.getMessage();
    }

    public BaseRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

}
