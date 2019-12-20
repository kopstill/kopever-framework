package com.kopdoctor.framework.common.exception;

public class ServiceRuntimeException extends RuntimeException {

    public ServiceRuntimeException(String message) {
        super(message);
    }

    public ServiceRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
