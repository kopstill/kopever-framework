package com.kopever.framework.common.entity;

import com.kopever.framework.common.exception.BusinessRuntimeException;
import com.kopever.framework.common.exception.IBaseRuntimeException;

public interface IRestCode extends IBaseRuntimeException {

    String getCode();

    String getMessage();

    default String code() {
        return getCode();
    }

    default String message() {
        return getMessage();
    }

    default RuntimeException toRuntimeException() {
        return new BusinessRuntimeException(code(), message());
    }

    default RuntimeException toRuntimeException(Object... parameters) {
        return new BusinessRuntimeException(getCode(), String.format(getMessage(), parameters));
    }

}
