package com.kopdoctor.framework.web.exception;

import com.kopdoctor.framework.api.entity.ResponseHead;
import com.kopdoctor.framework.common.entity.ErrorCode;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
@ResponseBody
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = new HashMap<>();
        errorAttributes.put("head", ResponseHead.builder().build().failure(ErrorCode.SYSTEM_EXCEPTION));
        return errorAttributes;
    }

}
