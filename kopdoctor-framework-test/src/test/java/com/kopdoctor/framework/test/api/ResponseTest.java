package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ResponseTest {

    @Test
    public void testResponse() {
        TempEntity tempEntity = new TempEntity();
        tempEntity.setId(123L).setName("name").setTime(new Date());

        Response<Void> defaultResponse = Response.success();
        System.out.println(Jackson.toJson(defaultResponse));
        Assert.assertTrue(defaultResponse.isSuccess());

        Response<Void> messageResponse = Response.successMessage("success message");
        System.out.println(Jackson.toJson(messageResponse));

        Response<String> stringResponse = Response.success("hello");
        System.out.println(Jackson.toJson(stringResponse));

        Response<TempEntity> entityResponse = Response.success(tempEntity);
        System.out.println(Jackson.toJson(entityResponse));

        Response<TempEntity> messageEntityResponse = Response.success("Okay", tempEntity);
        System.out.println(Jackson.toJson(messageEntityResponse));

        Response<Void> defaultErrorResponse = Response.error();
        System.out.println(Jackson.toJson(defaultErrorResponse));
        Assert.assertTrue(defaultErrorResponse.isError());

        Response<Void> messageErrorResponse = Response.errorMessage("failure message");
        System.out.println(Jackson.toJson(messageErrorResponse));

        Response<TempEntity> entityErrorResponse = Response.error(tempEntity);
        System.out.println(Jackson.toJson(entityErrorResponse));

        Response<Void> codeMessageErrorResponse = Response.error("-12138", "error message");
        System.out.println(Jackson.toJson(codeMessageErrorResponse));

        Response<TempEntity> codeMessageEntityErrorResponse = Response.error("-12138", "failed", tempEntity);
        System.out.println(Jackson.toJson(codeMessageEntityErrorResponse));

        Response<Void> errorCodeResponse = Response.errorCode("-9527");
        System.out.println(Jackson.toJson(errorCodeResponse));

        Response<TempEntity> errorCodeEntityResponse = Response.errorCode("-9527", tempEntity);
        System.out.println(Jackson.toJson(errorCodeEntityResponse));

        Response<TempEntity> errorMessageEntityResponse = Response.errorMessage("error entity message", tempEntity);
        System.out.println(Jackson.toJson(errorMessageEntityResponse));
    }

}
