package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.entity.IRestCode;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum BusinessCode implements IRestCode {

    DEMO_NOT_FOUND("10001", "示例未找到"),
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
