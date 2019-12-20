package com.kopdoctor.framework.common.entity;

import com.kopdoctor.framework.common.exception.ServiceRuntimeException;
import lombok.Getter;
import lombok.Setter;

public enum RestCode implements IRestCode {

    SUCCESS("0", "success"),
    FAILURE("-1", "failure"),
    SYSTEM_EXCEPTION("1", "system exception"),
    SYSTEM_RUNTIME_EXCEPTION("2", "system runtime exception"),
    RESOURCE_NOT_FOUND("3", "resource not found"),
    INTERNAL_SERVER_ERROR("4", "internal server error"),
    INVALID_REQUEST("5", "invalid request"),

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

    public ServiceRuntimeException toServiceRuntimeException() {
        return new ServiceRuntimeException(message);
    }

    public ServiceRuntimeException toServiceRuntimeException(String message) {
        return new ServiceRuntimeException(message);
    }

    public ServiceRuntimeException toServiceRuntimeException(String message, Throwable throwable) {
        return new ServiceRuntimeException(message, throwable);
    }

    public ServiceRuntimeException toServiceRuntimeException(Object... args) {
        return new ServiceRuntimeException(String.format(message, args));
    }

    @Getter
    @Setter
    private String code;

    @Getter
    @Setter
    private String message;

}
