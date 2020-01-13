package com.kopdoctor.framework.common.exception;

public class SystemRuntimeException extends BaseRuntimeException {

    public SystemRuntimeException(String message) {
        super(message);
    }

    public SystemRuntimeException(String code, String message) {
        super(code, message);
    }

}
