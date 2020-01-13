package com.kopdoctor.framework.common.exception;

import com.kopdoctor.framework.common.entity.RestCode;
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

    public BaseRuntimeException(String message) {
        this(RestCode.SYSTEM_RUNTIME_EXCEPTION.getCode(), message);
    }

    public BaseRuntimeException(String code, String message) {
        super(code + ":" + message);
        this.code = code;
        this.message = message;
    }

}
