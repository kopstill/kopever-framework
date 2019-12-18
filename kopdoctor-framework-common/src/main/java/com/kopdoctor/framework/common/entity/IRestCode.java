package com.kopdoctor.framework.common.entity;

public interface IRestCode {

    String getCode();

    String getMessage();

    default String code() {
        return getCode();
    }

    default String message() {
        return getMessage();
    }

}
