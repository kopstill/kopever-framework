package com.kopdoctor.framework.common.exception;

public abstract class BaseRuntimeException extends RuntimeException implements IBaseRuntimeException {

    public abstract String getCode();

    public abstract String getMsg();

    public BaseRuntimeException(String code, String msg, Throwable throwable) {
        super(code + ":" + msg, throwable);
    }

}
