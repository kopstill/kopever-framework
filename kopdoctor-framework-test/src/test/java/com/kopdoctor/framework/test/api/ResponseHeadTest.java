package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.ResponseHead;
import com.kopdoctor.framework.common.entity.RestCode;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Test;

public class ResponseHeadTest {

    @Test
    public void testResponseHead() {
        ResponseHead successHead = ResponseHead.success(RestCode.SUCCESS);
        System.out.println(Jackson.toJson(successHead));

        ResponseHead successCodeMessageHead = ResponseHead.success("0", "success message");
        System.out.println(Jackson.toJson(successCodeMessageHead));

        ResponseHead failureHead = ResponseHead.failure(RestCode.FAILURE);
        System.out.println(Jackson.toJson(failureHead));

        ResponseHead failureCodeMessageHead = ResponseHead.failure("-1", "failure message");
        System.out.println(Jackson.toJson(failureCodeMessageHead));
    }

}
