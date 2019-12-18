package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.entity.IRestCode;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum BusinessCode implements IRestCode {

    QUERY_SUCCESS("0", "查询成功"),
    SAVE_SUCCESS("0", "保存成功"),
    UPDATE_SUCCESS("0", "更新成功"),
    DELETE_SUCCESS("0", "删除成功"),
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
