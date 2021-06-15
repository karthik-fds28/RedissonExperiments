package com.logicbig.example.appviewxTest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AvxObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 2788344261861830527L;

    public AvxObjectMapper() {
        super();
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // Custom Annoatation introspector to handle AVX annotations.
        setAnnotationIntrospector(new AvxJacksonAnnotationIntrospector());
    }

    public AvxObjectMapper(JsonFactory jf) {
        super(jf);
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        setAnnotationIntrospector(new AvxJacksonAnnotationIntrospector());
    }


}
