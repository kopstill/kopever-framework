package com.kopever.framework.test.web;

import com.kopever.framework.api.entity.Response;
import com.kopever.framework.common.mapper.Dozer;
import com.kopever.framework.core.validation.ValidationGroup;
import com.kopever.framework.test.domain.dto.DemoDTO;
import com.kopever.framework.test.domain.mo.DemoMO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mongo")
public class MongoController {

    private final MongoTemplate mongoTemplate;

    @PostMapping("/test")
    public Response<DemoMO> saveToMongo(@RequestBody @Validated(ValidationGroup.Create.class) DemoDTO demoDTO) {
        DemoMO demo = mongoTemplate.save(Dozer.map(demoDTO, DemoMO.class));
        return Response.success(demo);
    }

}
