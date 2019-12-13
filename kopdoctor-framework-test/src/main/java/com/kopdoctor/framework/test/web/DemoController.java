package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.test.config.properties.DemoProperties;
import com.kopdoctor.framework.test.domain.dto.DemoDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
        return Response.success();
    }

    @GetMapping("/demo/config/single")
    public Response<String> configTest() {
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
    public Response<DemoDTO> postDemo() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(2L);
        demoDTO.setDemoName("post request");
        demoDTO.setCreateTime(new Date());

        return Response.success(demoDTO);
    }

    @PutMapping("/demo")
    public Response<DemoDTO> putDemo() {
        DemoDTO demoDTO = new DemoDTO();
        demoDTO.setId(3L);
        demoDTO.setDemoName("put request");
        demoDTO.setCreateTime(new Date());

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
