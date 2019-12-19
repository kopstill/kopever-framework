package com.kopdoctor.framework.web.exception;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Response<Void> handleRuntimeException(RuntimeException runtimeException) {
        logger.error("Handle runtime exception", runtimeException);

        if (runtimeException instanceof HttpMessageNotReadableException) {
            return Response.error(RestCode.INVALID_REQUEST);
        }

        return Response.error(RestCode.SYSTEM_RUNTIME_EXCEPTION);
    }

    @ExceptionHandler(Exception.class)
    public Response<Void> handleException(Exception exception) {
        logger.error("Handle generic exception", exception);

        if (exception instanceof MethodArgumentNotValidException || exception instanceof BindException) {
            FieldError fieldError;
            if (exception instanceof MethodArgumentNotValidException) {
                fieldError = ((MethodArgumentNotValidException) exception).getBindingResult().getFieldError();
            } else {
                fieldError = ((BindException) exception).getFieldError();
            }

            if (fieldError != null) {
                return Response.errorMessage("[" + fieldError.getField() + "]" + fieldError.getDefaultMessage());
            }
        }

        return Response.error(RestCode.SYSTEM_EXCEPTION);
    }

}
