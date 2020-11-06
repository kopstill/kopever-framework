package com.kopever.framework.common.exception;

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

}
