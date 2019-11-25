package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Test;

public class ResponseEntityTest {

    @Test
    public void test() {
        Response<Void> response = Response.success("hello");
        System.out.println(Jackson.toJson(response));
    }

}
