package com.logicbig.example.appviewxTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public class JsonParser {


    private ObjectMapper objectMapper;

    private JsonParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private JsonParser() {
        this.objectMapper = createObjectMapper();
    }

    public static JsonParser getParser() {
        return new JsonParser();
    }

    public static JsonParser getSanitizer() {
        JsonFactory factory = new JsonFactory();
        factory.setCharacterEscapes(new AvxCharacterEscapes());
        ObjectMapper mapper = new AvxObjectMapper(factory);
        return new JsonParser(mapper);
    }

    /**
     * Returns the object mapper by accepting the {@link ObjectMapper} instance.
     *
     * @param objectMapper {@link ObjectMapper} instance.
     * @return new {@link JsonParser} object.
     */
    public static JsonParser getParser(ObjectMapper objectMapper) {
        return new JsonParser(objectMapper);
    }

    private ObjectMapper createObjectMapper() {
        return new AvxObjectMapper();
    }

    public JsonParser allProperties() {
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return this;
    }

    private ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * @param obj The object to be converted into json.
     * @param <T> generic.
     * @return the curresponding json.
     * @throws IOException throws if any error occured during parsing.
     */
    public <T> String convertToJson(T obj) throws IOException {
        return getObjectMapper().writeValueAsString(obj);
    }

    /**
     * @param json  the input json.
     * @param klass class object of the bean.
     * @param <T>   generic.
     * @return the converted bean object.
     * @throws IOException throws if any error occurs.
     */
    public <T> T convertToBean(String json, Class<T> klass) throws IOException {
        return getObjectMapper().readValue(json, klass);
    }


    public <T> T convertToBean(File file, Class<T> klass) throws IOException {
        return getObjectMapper().readValue(file, klass);
    }

    public <T> T convertToBean(Object object, Class<T> klass) throws IOException {
        return getObjectMapper().convertValue(object, klass);
    }

    public <T> T convertToBean(Object object, Type type) throws IOException {
        final JavaType javaType = TypeFactory.defaultInstance().constructType(type);
        return getObjectMapper().convertValue(object, javaType);
    }


    public <T> T convertToBean(Object object, BeanType<T> beanType) throws IOException {
        final JavaType javaType = TypeFactory.defaultInstance().constructType(beanType.getType());
        return getObjectMapper().convertValue(object, javaType);
    }

    /**
     * Converts object to bean.
     *
     * @param json     input json.
     * @param beanType {@link BeanType} concrete class object containing the type
     *                 information.
     * @param <T>      generics information.
     * @return the converted object.
     * @throws IOException when the parsing fails.
     */
    public <T> T convertToBean(String json, BeanType<T> beanType) throws IOException {
        final JavaType javaType = TypeFactory.defaultInstance().constructType(beanType.getType());
        return getObjectMapper().readValue(json, javaType);
    }

    public <T> T convertToBean(String json, Type type) throws IOException {
        final JavaType javaType = TypeFactory.defaultInstance().constructType(type);
        return getObjectMapper().readValue(json, javaType);
    }

}
