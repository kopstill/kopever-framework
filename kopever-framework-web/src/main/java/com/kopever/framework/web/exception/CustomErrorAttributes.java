package com.kopever.framework.web.exception;

import com.kopever.framework.api.entity.ResponseHead;
import com.kopever.framework.common.entity.RestCode;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>();
        errorAttributes.put("head", ResponseHead.failure(RestCode.SYSTEM_EXCEPTION));
        return errorAttributes;
    }

}
