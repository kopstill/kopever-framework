package com.kopever.framework.web.exception;

import com.kopever.framework.api.entity.Response;
import com.kopever.framework.common.entity.RestCode;
import com.kopever.framework.common.exception.BusinessRuntimeException;
import com.kopever.framework.common.exception.SystemRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Response<Void> handleRuntimeException(RuntimeException runtimeException) {
        logger.error("Handle runtime exception", runtimeException);

        if (runtimeException instanceof BusinessRuntimeException) {
            BusinessRuntimeException businessRuntimeException = (BusinessRuntimeException) runtimeException;
            return Response.error(businessRuntimeException.getCode(), businessRuntimeException.getMessage());
        } else if (runtimeException instanceof SystemRuntimeException) {
            SystemRuntimeException systemRuntimeException = (SystemRuntimeException) runtimeException;
            return Response.error(systemRuntimeException.getCode(), systemRuntimeException.getMessage());
        } else if (runtimeException instanceof HttpMessageNotReadableException) {
            return Response.error(RestCode.INVALID_REQUEST);
        } else if (runtimeException instanceof MethodArgumentTypeMismatchException) {
            return Response.error(RestCode.INVALID_ARGUMENT_TYPE);
        }

        return Response.error(RestCode.SYSTEM_RUNTIME_EXCEPTION);
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    public Response<Void> handleBindException(Exception exception) {
        logger.error("Handle bind exception");

        FieldError fieldError;
        if (exception instanceof BindException) {
            fieldError = ((BindException) exception).getFieldError();
        } else {
            fieldError = ((MethodArgumentNotValidException) exception).getBindingResult().getFieldError();
        }

        if (fieldError != null) {
            return Response.errorMessage(fieldError.getDefaultMessage());
        }

        return Response.error(RestCode.INVALID_REQUEST);
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response<Void> noHandlerFoundException(NoHandlerFoundException e) {
        logger.error(e.getMessage());
        return Response.error(RestCode.RESOURCE_NOT_FOUND);
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
