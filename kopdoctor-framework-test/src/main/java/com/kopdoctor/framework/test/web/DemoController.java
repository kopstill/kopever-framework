package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import com.kopdoctor.framework.core.validation.ValidationGroup;
import com.kopdoctor.framework.test.config.properties.DemoProperties;
import com.kopdoctor.framework.test.domain.dto.DemoDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.AlreadyConnectedException;
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
        throw RestCode.QUERY_FAILED.toServiceRuntimeException();
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
    public Response<DemoDTO> getDemo() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(1L);
        demoDTO.setDemoName("get request");
        demoDTO.setCreateTime(new Date());

        return Response.success(RestCode.QUERY_SUCCEED, demoDTO);
    }

    @PostMapping("/demo")
    public Response<DemoDTO> postDemo(@RequestBody @Validated(ValidationGroup.Create.class) DemoDTO demoDTO) {
        return Response.success(RestCode.SAVE_SUCCEED, demoDTO);
    }

    @PutMapping("/demo")
    public Response<DemoDTO> putDemo(@RequestBody @Validated(ValidationGroup.Update.class) DemoDTO demoDTO) {
        return Response.success(RestCode.UPDATE_SUCCEED, demoDTO);
    }

    @DeleteMapping("/demo")
    public Response<DemoDTO> deleteDemo() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(4L);
        demoDTO.setDemoName("delete request");
        demoDTO.setCreateTime(new Date());

        return Response.success(RestCode.DELETE_SUCCEED, demoDTO);
    }

}
