package com.kopdoctor.framework.web.exception;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.ErrorCode;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Response<ErrorCode> handleRuntimeException(RuntimeException runtimeException) {
        if (runtimeException instanceof HttpMessageNotReadableException) {
            return Response.error(ErrorCode.REQUEST_EXCEPTION);
        }

        return Response.error(ErrorCode.SYSTEM_RUNTIME_EXCEPTION);
    }

    @ExceptionHandler(Exception.class)
    public Response<ErrorCode> handleException() {
        return Response.error(ErrorCode.SYSTEM_EXCEPTION);
    }

}
