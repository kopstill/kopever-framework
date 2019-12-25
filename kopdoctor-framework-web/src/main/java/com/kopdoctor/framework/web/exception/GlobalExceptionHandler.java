package com.kopdoctor.framework.web.exception;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import com.kopdoctor.framework.common.exception.BusinessRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessRuntimeException.class)
    public Response<Void> handleBusinessRuntimeException(BusinessRuntimeException businessRuntimeException) {
        return Response.error(businessRuntimeException.getCode(), businessRuntimeException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Response<Void> handleRuntimeException(RuntimeException runtimeException) {
        logger.error("Handle runtime exception", runtimeException);

        if (runtimeException instanceof HttpMessageNotReadableException) {
            return Response.error(RestCode.INVALID_REQUEST);
        }

        return Response.error(RestCode.SYSTEM_RUNTIME_EXCEPTION);
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public Response<Void> handleBindException(Exception exception) {
        logger.error("Handle bind exception", exception);

        FieldError fieldError;
        if (exception instanceof BindException) {
            fieldError = ((BindException) exception).getFieldError();
        } else {
            fieldError = ((MethodArgumentNotValidException) exception).getBindingResult().getFieldError();
        }

        if (fieldError != null) {
            return Response.errorMessage("[" + fieldError.getField() + "]" + fieldError.getDefaultMessage());
        }

        return Response.error(RestCode.INVALID_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public Response<Void> handleException(Exception exception) {
        logger.error("Handle generic exception", exception);

        if (exception instanceof MissingServletRequestParameterException) {
            return Response.errorMessage(exception.getMessage());
        } else if (exception instanceof HttpMediaTypeNotSupportedException) {
            return Response.error(RestCode.HTTP_MEDIA_NOT_SUPPORT);
        } else if (exception instanceof HttpRequestMethodNotSupportedException) {
            return Response.error(RestCode.METHOD_NOT_ALLOWED);
        }

        return Response.error(RestCode.SYSTEM_EXCEPTION);
    }

}
