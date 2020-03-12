package com.kopdoctor.framework.common.entity;

import lombok.Getter;
import lombok.Setter;

public enum RestCode implements IRestCode {

    SUCCESS("0", "success"),
    FAILURE("-1", "failure"),
    SYSTEM_EXCEPTION("1", "system exception"),
    SYSTEM_RUNTIME_EXCEPTION("2", "system runtime exception"),
    INTERNAL_SERVER_ERROR("3", "internal server error"),
    INVALID_REQUEST("4", "invalid request"),
    RESOURCE_NOT_FOUND("5", "resource not found"),
    HTTP_MEDIA_NOT_SUPPORT("6", "http media not support"),
    METHOD_NOT_ALLOWED("7", "method not allowed"),

    QUERY_SUCCEED("0", "查询成功"),
    SAVE_SUCCEED("0", "保存成功"),
    ADD_SUCCEED("0", "新增成功"),
    UPDATE_SUCCEED("0", "更新成功"),
    MODIFY_SUCCEED("0", "修改成功"),
    DELETE_SUCCEED("0", "删除成功"),
    EXPORT_SUCCEED("0", "导出成功"),

    QUERY_FAILED("-1", "查询失败"),
    SAVE_FAILED("-1", "保存失败"),
    ADD_FAILED("-1", "新增失败"),
    UPDATE_FAILED("-1", "更新失败"),
    MODIFY_FAILED("-1", "修改失败"),
    EXPORT_FAILED("-1", "导出失败"),
    ;

    RestCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    private String code;

    @Getter
    private String message;

}
