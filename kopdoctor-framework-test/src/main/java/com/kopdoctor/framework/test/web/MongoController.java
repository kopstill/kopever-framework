package com.kopdoctor.framework.test.web;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.test.domain.mo.DemoMO;
import com.kopdoctor.framework.test.service.MongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController(value = "/mongo")
public class MongoController {

    private final MongoService mongoService;

    @PostMapping
    public Response<Object> saveToMongo(DemoMO demoDTO) {
        return Response.success(mongoService.save(demoDTO));
    }

}
