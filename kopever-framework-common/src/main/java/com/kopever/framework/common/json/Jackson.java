package com.kopever.framework.common.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.type.CollectionType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Jackson {

    private static final ObjectMapper objectMapper;

    private static final ObjectMapper snakeMapper;

    private static final ObjectMapper ignoreNullMapper;

    private static final PropertyNamingStrategy.SnakeCaseStrategy snakeCaseStrategy;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        snakeMapper = new ObjectMapper();
        snakeMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        snakeMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        ignoreNullMapper = new ObjectMapper();
        snakeMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ignoreNullMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        snakeCaseStrategy = new PropertyNamingStrategy.SnakeCaseStrategy();
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return fromJsonViaJavaType(json, objectMapper.constructType(clazz), false);
    }

    public static <T> T fromJson(String json, Class<?> rawClass, Class<?> elementClass) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(rawClass, elementClass);
        return fromJsonViaJavaType(json, javaType, false);
    }

    public static <T> T fromJson(String json, Class<?> rawClass, Class<? extends Collection> collectionClass, Class<?> elementClass) {
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(rawClass, collectionType);
        return fromJsonViaJavaType(json, javaType, false);
    }

    public static <T> T fromJsonSnakeCase(String json, Class<T> clazz) {
        return fromJsonViaJavaType(json, objectMapper.constructType(clazz), true);
    }

    public static <T> T fromJsonSnakeCase(String json, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        return fromJsonViaJavaType(json, javaType, true);
    }

    private static <T> T fromJsonViaJavaType(String json, JavaType javaType, boolean isSnakeCase) {
        try {
            return isSnakeCase ? snakeMapper.readValue(json, javaType) : objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Map<String, Object> jsonToMap(String json) {
        return jsonToMap(json, String.class, Object.class);
    }

    public static <K, V> Map<K, V> jsonToMap(String json, Class<K> keyClass, Class<V> valueClass) {
        return fromJsonViaJavaType(json, objectMapper.getTypeFactory().constructMapType(Map.class, keyClass, valueClass), false);
    }

    public static <T> List<T> jsonToList(String json, Class<T> elementClass) {
        return fromJsonViaJavaType(json, objectMapper.getTypeFactory().constructCollectionType(List.class, elementClass), false);
    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toJsonSnakeCase(Object object) {
        try {
            return snakeMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toJsonIgnoreNull(Object object) {
        try {
            return ignoreNullMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toPrettyJson(Object object) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toPrettyJsonSnakeCase(Object object) {
        try {
            return snakeMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String toSnakeCase(String input) {
        return snakeCaseStrategy.translate(input);
    }

}
