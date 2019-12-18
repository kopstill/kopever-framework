package com.kopdoctor.framework.web.exception;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Response<RestCode> handleRuntimeException(RuntimeException runtimeException) {
        if (runtimeException instanceof HttpMessageNotReadableException) {
            return Response.error(RestCode.REQUEST_EXCEPTION);
        }

        return Response.error(RestCode.SYSTEM_RUNTIME_EXCEPTION);
    }

    @ExceptionHandler(Exception.class)
    public Response<RestCode> handleException() {
        return Response.error(RestCode.SYSTEM_EXCEPTION);
    }

}
