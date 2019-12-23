package com.kopdoctor.framework.common.exception;

public class BusinessRuntimeException extends BaseRuntimeException {

    private final String code;

    private final String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public BusinessRuntimeException(String code, String message) {
        this(code, message, null);
    }

    public BusinessRuntimeException(String code, String msg, Throwable throwable) {
        super(code, msg, throwable);
        this.code = code;
        this.msg = msg;
    }

}
