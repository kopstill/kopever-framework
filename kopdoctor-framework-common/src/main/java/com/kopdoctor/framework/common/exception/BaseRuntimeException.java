package com.kopdoctor.framework.common.exception;

import lombok.Getter;

public abstract class BaseRuntimeException extends RuntimeException implements IBaseRuntimeException {

    @Getter
    private final String code;

    @Getter
    private final String message;

    @Override
    public String getLocalizedMessage() {
        return code + ":" + message;
    }

    public BaseRuntimeException(String code, String message, Throwable throwable) {
        super(code + ":" + message, throwable);
        this.code = code;
        this.message = message;
    }

}
