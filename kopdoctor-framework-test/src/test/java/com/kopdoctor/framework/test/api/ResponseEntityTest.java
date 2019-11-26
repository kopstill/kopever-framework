package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.api.entity.ResponseHead;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Test;

import java.util.Date;

public class ResponseEntityTest {

    @Test
    public void testJackson() {
        Response<Long> response = Response.success("hello");
        System.out.println(Jackson.toJson(response));

        ResponseHead head = ResponseHead.builder().code("0").message("message").encoding("encoding").requestId("requestId").taketime(123L).timestamp(321L).build();
        System.out.println(Jackson.toJson(head));

        TempEntity tempEntity = new TempEntity();
        tempEntity.setId(123L).setName("name").setTime(new Date());
        System.out.println(Jackson.toJson(tempEntity));

        Response<TempEntity> response1 = Response.success(tempEntity);
        System.out.println(Jackson.toJson(response1));
    }

}
