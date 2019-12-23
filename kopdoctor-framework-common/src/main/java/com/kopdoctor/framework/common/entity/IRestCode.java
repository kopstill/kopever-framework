package com.kopdoctor.framework.common.entity;

import com.kopdoctor.framework.common.exception.BusinessRuntimeException;
import com.kopdoctor.framework.common.exception.IBaseRuntimeException;

public interface IRestCode extends IBaseRuntimeException {

    String getCode();

    String getMsg();

    default String code() {
        return getCode();
    }

    default String message() {
        return getMessage();
    }

    default RuntimeException toRuntimeException() {
        return new BusinessRuntimeException(code(), message());
    }

    default RuntimeException toRuntimeException(Object... params) {
        return new BusinessRuntimeException(getCode(), String.format(getMessage(), params));
    }

}
