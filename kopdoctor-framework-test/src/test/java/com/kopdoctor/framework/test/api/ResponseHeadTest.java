package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.ResponseHead;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Assert;
import org.junit.Test;

public class ResponseHeadTest {

    @Test
    public void testResponseHead() {
        ResponseHead successHead = ResponseHead.builder().build().success();
        System.out.println(Jackson.toJson(successHead));
        Assert.assertFalse(successHead.isError());

        ResponseHead successMessageHead = ResponseHead.builder().build().success("success message");
        System.out.println(Jackson.toJson(successMessageHead));

        ResponseHead failureHead = ResponseHead.builder().build().failure();
        System.out.println(Jackson.toJson(failureHead));

        ResponseHead failureMessageHead = ResponseHead.builder().build().failure("failure message");
        System.out.println(Jackson.toJson(failureMessageHead));

        ResponseHead failureCodeMessageHead = ResponseHead.builder().build().failure("-12138", "failure message");
        System.out.println(Jackson.toJson(failureCodeMessageHead));
    }

}
