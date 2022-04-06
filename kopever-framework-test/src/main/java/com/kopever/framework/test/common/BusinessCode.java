package com.kopever.framework.test.common;

import com.kopever.framework.common.entity.IRestCode;
import lombok.Getter;

@Getter
public enum BusinessCode implements IRestCode {

    DEMO_SUCCESS("10001", "示例成功"),
    DEMO_EXCEPTION("10002", "示例异常"),
    DEMO_EXCEPTION1("10003", "示例异常占位符[%s]"),
    ;

    BusinessCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    private final String code;

    @Getter
    private final String message;

}
