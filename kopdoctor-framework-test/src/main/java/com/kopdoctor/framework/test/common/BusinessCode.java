package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.entity.IRestCode;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum BusinessCode implements IRestCode {

    DEMO_EXCEPTION("10001", "示例异常"),
    DEMO_EXCEPTION1("10002", "示例异常占位符[%s]"),
    ;

    BusinessCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String message;

}
