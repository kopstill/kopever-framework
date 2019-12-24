package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.ResponseHead;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Assert;
import org.junit.Test;

public class ResponseHeadTest {

    @Test
    public void testResponseHead() {
        ResponseHead successHead = ResponseHead.success();
        System.out.println(Jackson.toJson(successHead));
        Assert.assertFalse(successHead.isError());

        ResponseHead successMessageHead = ResponseHead.success("success message");
        System.out.println(Jackson.toJson(successMessageHead));

        ResponseHead failureHead = ResponseHead.failure();
        System.out.println(Jackson.toJson(failureHead));

        ResponseHead failureMessageHead = ResponseHead.failure("failure message");
        System.out.println(Jackson.toJson(failureMessageHead));

        ResponseHead failureCodeMessageHead = ResponseHead.failure("-12138", "failure message");
        System.out.println(Jackson.toJson(failureCodeMessageHead));
    }

}
