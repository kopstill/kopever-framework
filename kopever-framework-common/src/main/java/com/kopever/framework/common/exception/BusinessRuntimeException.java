package com.kopever.framework.common.exception;

public class BusinessRuntimeException extends BaseCodedRuntimeException {

    public BusinessRuntimeException(String code, String message) {
        super(code, message);
    }

    public BusinessRuntimeException(String code, String message, Throwable throwable) {
        super(code, message, throwable);
    }

}
