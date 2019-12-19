package com.kopdoctor.framework.web.controller;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Slf4j
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends AbstractErrorController {

    @Value("${server.error.path:${error.path:/error}}")
    private String errorPath;

    public CustomErrorController(final ErrorAttributes errorAttributes) {
        super(errorAttributes, Collections.emptyList());
    }

    @RequestMapping
    public Response<Void> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        logger.error(status.toString());

        if (status == HttpStatus.NOT_FOUND) {
            return Response.error(RestCode.RESOURCE_NOT_FOUND);
        } else if (status == HttpStatus.INTERNAL_SERVER_ERROR) {
            return Response.error(RestCode.INTERNAL_SERVER_ERROR);
        }

        return Response.error(RestCode.SYSTEM_EXCEPTION);
    }

    @Override
    public String getErrorPath() {
        return errorPath;
    }

}
