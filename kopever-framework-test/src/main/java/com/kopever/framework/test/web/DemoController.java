package com.kopever.framework.test.web;

import com.kopever.framework.api.entity.Response;
import com.kopever.framework.common.entity.RestCode;
import com.kopever.framework.common.exception.SystemRuntimeException;
import com.kopever.framework.common.mapper.Dozer;
import com.kopever.framework.core.validation.ValidationGroup;
import com.kopever.framework.redis.Redis;
import com.kopever.framework.test.common.BusinessCode;
import com.kopever.framework.test.configuration.properties.DemoProperties;
import com.kopever.framework.test.domain.vo.DemoVO;
import com.kopever.framework.test.domain.vo.RedisDemoVO;
//import com.kopever.framework.test.service.DemoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RefreshScope
@RequiredArgsConstructor
@RestController
public class DemoController {

//    private final DemoService demoService;

    @Value("${demo.name}")
    private String demoName;

    @NonNull
    private DemoProperties demoProperties;

    private final Redis redis;

    @GetMapping("/log")
    public Response<Void> log() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return Response.success();
    }

    @GetMapping("/demo/success")
    public Response<Void> demoSuccess() {
        return Response.success(BusinessCode.DEMO_SUCCESS);
    }

    @GetMapping("/exception")
    public void exception() {
        throw RestCode.QUERY_FAILED.toRuntimeException();
    }

    @GetMapping("/exception/runtime/system")
    public void systemRuntimeException() {
        throw new SystemRuntimeException("This is system runtime exception");
    }

    @GetMapping("/exception/required")
    public Response<String> requiredException(@RequestParam String required) {
        return Response.success(required);
    }

    @GetMapping("/exception/placeholder")
    public void exceptionWithPlaceholder(@RequestParam(required = false) String placeholder) {
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

//    @GetMapping("/demo")
//    public Response<List<DemoVO>> getDemo() {
//        List<DemoVO> list = new ArrayList<>();
//        demoService.selectAll().forEach(data -> list.add(Dozer.map(data, DemoVO.class)));
//
//        return Response.success(RestCode.QUERY_SUCCEED, list.isEmpty() ? null : list);
//    }

    @PostMapping("/demo")
    public Response<DemoVO> postDemo(@RequestBody @Validated(ValidationGroup.Create.class) DemoVO demoVO) {
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

    @PostMapping(value = "/demo/form-urlencoded", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Response<DemoVO> formUrlencodedDemo(@Validated(ValidationGroup.Create.class) DemoVO demoVO) {
        return Response.success(demoVO);
    }

    @PostMapping(value = "/demo/form-data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response<DemoVO> formDataDemo(@Validated(ValidationGroup.Create.class) DemoVO demoVO) {
        return Response.success(demoVO);
    }

    @PostMapping("/redis")
    public Response<Void> redisDemo(@RequestBody RedisDemoVO vo) {
        redis.set(vo.getRedisKey(), vo.getRedisValue());
        return Response.success();
    }

}
