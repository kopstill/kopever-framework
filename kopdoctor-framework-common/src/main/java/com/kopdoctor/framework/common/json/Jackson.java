package com.kopdoctor.framework.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Jackson {

    private static ObjectMapper objectMapper;

    public static <T> T fromJson(String json, Class<T> clazz) {
        return fromJsonViaJavaType(json, objectMapper.constructType(clazz));
    }

    private static <T> T fromJsonViaJavaType(String json, JavaType javaType) {
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            throw new IllegalArgumentException("Jackson deserialization exception" + e.getMessage(), e);
        }
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Jackson serialization exception", e);
        }
    }

}
