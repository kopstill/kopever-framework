package com.kopdoctor.framework.common.exception;

public class BusinessRuntimeException extends BaseRuntimeException {

    public BusinessRuntimeException(String code, String message) {
        this(code, message, null);
    }

    public BusinessRuntimeException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }

}
