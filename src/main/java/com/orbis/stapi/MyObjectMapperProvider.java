package com.orbis.stapi;

import java.text.*;
import java.util.*;
import javax.ws.rs.ext.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

/**
 * User: Daniil Sosonkin
 * Date: 9/5/2018 9:41 AM
 */
@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper>
    {
        public static final ObjectMapper mapper = new ObjectMapper() {{
            enable(SerializationFeature.INDENT_OUTPUT);
            setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            setDateFormat(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z", Locale.US));
            configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        }};

        @Override
        public ObjectMapper getContext(Class<?> type)
            {
                return mapper;
            }
    }
