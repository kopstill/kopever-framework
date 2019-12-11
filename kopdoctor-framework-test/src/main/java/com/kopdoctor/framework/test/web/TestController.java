package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.test.domain.TestDO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TestController {

    @Value("${hello}")
    private String consulConfigValue;

    @GetMapping
    public Response<String> root() {
        return Response.success(consulConfigValue);
    }

    @GetMapping("/test")
    public Response<TestDO> getTest() {
        TestDO testDO = new TestDO();
        testDO.setId(1L);
        testDO.setName("get request");
        testDO.setCreateTime(new Date());

        return Response.success(testDO);
    }

    @PostMapping("/test")
    public Response<TestDO> postTest() {
        TestDO testDO = new TestDO();
        testDO.setId(2L);
        testDO.setName("post request");
        testDO.setCreateTime(new Date());

        return Response.success(testDO);
    }

    @PutMapping("/test")
    public Response<TestDO> putTest() {
        TestDO testDO = new TestDO();
        testDO.setId(3L);
        testDO.setName("put request");
        testDO.setCreateTime(new Date());

        return Response.success(testDO);
    }

    @DeleteMapping("/test")
    public Response<TestDO> deleteTest() {
        TestDO testDO = new TestDO();
        testDO.setId(4L);
        testDO.setName("delete request");
        testDO.setCreateTime(new Date());

        return Response.success(testDO);
    }

}
