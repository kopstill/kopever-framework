package com.kopdoctor.framework.common.exception;

public class BusinessRuntimeException extends BaseCodedRuntimeException {

    public BusinessRuntimeException(String code, String message) {
        super(code, message);
    }

}
