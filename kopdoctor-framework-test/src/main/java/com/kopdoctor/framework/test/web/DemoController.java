package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.core.validation.ValidationGroup;
import com.kopdoctor.framework.test.config.properties.DemoProperties;
import com.kopdoctor.framework.test.domain.dto.DemoDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RefreshScope
@RequiredArgsConstructor
public class DemoController {

    @Value("${demo.name}")
    private String demoName;

    @NonNull
    private DemoProperties demoProperties;

    @GetMapping
    public Response<Void> root() {
        if ("1".equals("1")) {
            throw new RuntimeException();
        }
        return Response.success();
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

        return Response.success(demoDTO);
    }

    @PostMapping("/demo")
    public Response<DemoDTO> postDemo(@RequestBody @Validated(ValidationGroup.Create.class) DemoDTO demoDTO) {
        return Response.success(demoDTO);
    }

    @PutMapping("/demo")
    public Response<DemoDTO> putDemo(@RequestBody @Validated(ValidationGroup.Update.class) DemoDTO demoDTO) {
        return Response.success(demoDTO);
    }

    @DeleteMapping("/demo")
    public Response<DemoDTO> deleteDemo() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(4L);
        demoDTO.setDemoName("delete request");
        demoDTO.setCreateTime(new Date());

        return Response.success(demoDTO);
    }

}
