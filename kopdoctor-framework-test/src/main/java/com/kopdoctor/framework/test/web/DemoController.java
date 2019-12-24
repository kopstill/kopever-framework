package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import com.kopdoctor.framework.core.validation.ValidationGroup;
import com.kopdoctor.framework.test.common.BusinessCode;
import com.kopdoctor.framework.test.config.properties.DemoProperties;
import com.kopdoctor.framework.test.domain.vo.DemoVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RefreshScope
@RequiredArgsConstructor
@RestController
public class DemoController {

    @Value("${demo.name}")
    private String demoName;

    @NonNull
    private DemoProperties demoProperties;

    @GetMapping("/log")
    public Response<Void> log() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return Response.success();
    }

    @GetMapping("/exception")
    public void exception() {
        throw RestCode.QUERY_FAILED.toRuntimeException();
    }

    @GetMapping("/exception/placeholder")
    public void exception1(String placeholder) {
        throw BusinessCode.DEMO_EXCEPTION1.toRuntimeException(placeholder);
    }

    @GetMapping("/demo/config/single")
    public Response<String> testConfigSingle() {
        return Response.success(demoName);
    }

    @GetMapping("/demo/config/entity")
    public Response<DemoProperties> testConfigEntity() {
        return Response.success(demoProperties);
    }

    @GetMapping("/demo")
    public Response<com.kopdoctor.framework.test.domain.vo.DemoVO> getDemo() {
        com.kopdoctor.framework.test.domain.vo.DemoVO demoVO = new com.kopdoctor.framework.test.domain.vo.DemoVO();
        demoVO.setId(1L);
        demoVO.setDemoName("get request");
        demoVO.setCreateTime(new Date());

        return Response.success(RestCode.QUERY_SUCCEED, demoVO);
    }

    @PostMapping("/demo")
    public Response<com.kopdoctor.framework.test.domain.vo.DemoVO> postDemo(@RequestBody @Validated(ValidationGroup.Create.class) com.kopdoctor.framework.test.domain.vo.DemoVO demoVO) {
        return Response.success(RestCode.SAVE_SUCCEED, demoVO);
    }

    @PutMapping("/demo")
    public Response<DemoVO> putDemo(@RequestBody @Validated(ValidationGroup.Update.class) DemoVO demoVO) {
        return Response.success(RestCode.UPDATE_SUCCEED, demoVO);
    }

    @DeleteMapping("/demo")
    public Response<DemoVO> deleteDemo() {
        DemoVO demoVO = new DemoVO();
        demoVO.setId(4L);
        demoVO.setDemoName("delete request");
        demoVO.setCreateTime(new Date());

        return Response.success(RestCode.DELETE_SUCCEED, demoVO);
    }

}
