package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.test.domain.data.DemoDO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class DemoController {

    @GetMapping
    public Response<Void> root() {
        return Response.success();
    }

    @GetMapping("/demo")
    public Response<DemoDO> getTest() {
        DemoDO demoDO = new DemoDO();
        demoDO.setId(1L);
        demoDO.setName("get request");
        demoDO.setCreateTime(new Date());

        return Response.success(demoDO);
    }

    @PostMapping("/demo")
    public Response<DemoDO> postTest() {
        DemoDO demoDO = new DemoDO();
        demoDO.setId(2L);
        demoDO.setName("post request");
        demoDO.setCreateTime(new Date());

        return Response.success(demoDO);
    }

    @PutMapping("/demo")
    public Response<DemoDO> putTest() {
        DemoDO demoDO = new DemoDO();
        demoDO.setId(3L);
        demoDO.setName("put request");
        demoDO.setCreateTime(new Date());

        return Response.success(demoDO);
    }

    @DeleteMapping("/demo")
    public Response<DemoDO> deleteTest() {
        DemoDO demoDO = new DemoDO();
        demoDO.setId(4L);
        demoDO.setName("delete request");
        demoDO.setCreateTime(new Date());

        return Response.success(demoDO);
    }

}
