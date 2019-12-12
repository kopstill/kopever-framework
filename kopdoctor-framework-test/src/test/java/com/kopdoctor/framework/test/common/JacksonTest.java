package com.kopdoctor.framework.test.common;

import com.kopdoctor.framework.common.json.Jackson;
import com.kopdoctor.framework.test.domain.dto.UserDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JacksonTest {

    @Test
    public void testJackson() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(12138L);
        userDTO.setCreateTime(new Date());
        System.out.println(Jackson.toJson(userDTO));

        String json = "{\"id\":12138,\"username\":null,\"nickname\":null,\"userType\":null,\"userStatus\":null,\"channel\":null,\"createTime\":1575970645210}";
        System.out.println(Jackson.fromJson(json, UserDTO.class).getCreateTime());
        System.out.println(Jackson.fromJson(json, Map.class));

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", 12138);
        userMap.put("date", new Date());
        System.out.println(Jackson.toJson(userMap));

        Assert.assertTrue(true);

        System.out.println(Jackson.jsonToMap(json));
        System.out.println(Jackson.jsonToMap(json, String.class, String.class));

        System.out.println(Jackson.toPrettyJson(userDTO));

        System.out.println(Jackson.jsonToList("[\"hello\",\"world\",12138]", String.class));
    }

    @Test
    public void testJacksonSnakeCase() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(12138L);
        userDTO.setUserType(1);
        userDTO.setUserStatus(3);
        userDTO.setCreateTime(new Date());
        System.out.println(Jackson.toJsonSnakeCase(userDTO));
        System.out.println(Jackson.toPrettyJsonSnakeCase(userDTO));

        Assert.assertTrue(true);

        String json = "{\"id\":12138,\"username\":null,\"nickname\":null,\"user_type\":1,\"user_status\":3,\"channel\":null,\"create_time\":\"2019-12-12 17:47:51\"}";
        System.out.println(Jackson.fromJsonSnakeCase(json, UserDTO.class).getUserType());
        System.out.println(Jackson.fromJsonSnakeCase(json, UserDTO.class).getUserStatus());
    }

}
