package com.kopdoctor.framework.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Jackson {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return fromJsonViaJavaType(json, objectMapper.constructType(clazz));
    }

    private static <T> T fromJsonViaJavaType(String json, JavaType javaType) {
        try {
            return objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Jackson deserialization exception", e);
        }
    }

    public static Map<String, Object> jsonToMap(String json) {
        return jsonToMap(json, String.class, Object.class);
    }

    public static <K, V> Map<K, V> jsonToMap(String json, Class<K> keyClass, Class<V> valueClass) {
        return fromJsonViaJavaType(json, objectMapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass));
    }

    public static <T> List<T> jsonToList(String json, Class<T> elementClass) {
        return fromJsonViaJavaType(json, objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass));
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Jackson serialization exception", e);
        }
    }

    public static String toPrettyJson(Object object) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Jackson serialization exception", e);
        }
    }

}
