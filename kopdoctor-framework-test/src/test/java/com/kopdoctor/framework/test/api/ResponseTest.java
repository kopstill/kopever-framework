package com.kopdoctor.framework.test.api;

import com.kopdoctor.framework.api.entity.Response;
import com.kopdoctor.framework.common.entity.RestCode;
import com.kopdoctor.framework.common.json.Jackson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ResponseTest {

    @Test
    public void testResponse() {
        TempEntity tempEntity = new TempEntity();
        tempEntity.setId(123L).setName("name").setTime(new Date());

        Response<Void> success0 = Response.success();
        System.out.println(Jackson.toJson(success0));

        Response<Void> success1 = Response.success(RestCode.QUERY_SUCCEED);
        System.out.println(Jackson.toJson(success1));

        Response<TempEntity> success2 = Response.success(tempEntity);
        System.out.println(Jackson.toJson(success2));

        Response<TempEntity> success3 = Response.success(RestCode.ADD_SUCCEED, tempEntity);
        System.out.println(Jackson.toJson(success3));

        Response<Void> success4 = Response.success("SUCCESS", "保存成功");
        System.out.println(Jackson.toJson(success4));

        Response<TempEntity> success5 = Response.success("SUCCESS", "更新成功", tempEntity);
        System.out.println(Jackson.toJson(success5));

        Response<Void> success6 = Response.successCode("SUCCESS");
        System.out.println(Jackson.toJson(success6));

        Response<TempEntity> success7 = Response.successCode("SUCCESS", tempEntity);
        System.out.println(Jackson.toJson(success7));

        Response<Void> success8 = Response.successMessage("SUCCESS MESSAGE");
        System.out.println(Jackson.toJson(success8));

        Response<TempEntity> success9 = Response.successMessage("SUCCESS MESSAGE", tempEntity);
        System.out.println(Jackson.toJson(success9));
        Assert.assertTrue(success9.isSuccess());

        Response<Void> error0 = Response.error();
        System.out.println(Jackson.toJson(error0));

        Response<Void> error1 = Response.error(RestCode.QUERY_FAILED);
        System.out.println(Jackson.toJson(error1));

        Response<TempEntity> error2 = Response.error(tempEntity);
        System.out.println(Jackson.toJson(error2));

        Response<TempEntity> error3 = Response.error(RestCode.ADD_FAILED, tempEntity);
        System.out.println(Jackson.toJson(error3));

        Response<Void> error4 = Response.error("FAILURE", "保存失败");
        System.out.println(Jackson.toJson(error4));

        Response<TempEntity> error5 = Response.error("FAILURE", "更新失败", tempEntity);
        System.out.println(Jackson.toJson(error5));

        Response<Void> error6 = Response.errorCode("FAILURE");
        System.out.println(Jackson.toJson(error6));

        Response<TempEntity> error7 = Response.errorCode("FAILURE", tempEntity);
        System.out.println(Jackson.toJson(error7));

        Response<Void> error8 = Response.errorMessage("FAILURE MESSAGE");
        System.out.println(Jackson.toJson(error8));

        Response<TempEntity> error9 = Response.errorMessage("FAILURE MESSAGE", tempEntity);
        System.out.println(Jackson.toJson(error9));
        Assert.assertTrue(error9.isError());
    }

}
