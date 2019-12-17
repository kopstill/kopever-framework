package com.kopdoctor.framework.web.exception;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.ErrorCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Response<ErrorCode> handleRuntimeException() {
        return Response.error(ErrorCode.SYSTEM_EXCEPTION);
    }

}
