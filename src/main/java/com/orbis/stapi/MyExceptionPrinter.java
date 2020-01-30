package com.orbis.stapi;

import java.util.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;
import org.apache.logging.log4j.*;

/**
 * User: Daniil Sosonkin
 * Date: 9/5/2018 1:06 PM
 */
@Provider
public class MyExceptionPrinter implements ExceptionMapper<Exception>
    {
        private Logger logger = LogManager.getLogger(getClass());

        @Override
        public Response toResponse(Exception e)
            {
                UUID uuid = UUID.randomUUID();
                String msg = e.getMessage();
                Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;

                Map<String, Object> map = new HashMap<>();
                map.put("timestamp", new Date());
                map.put("error", msg);
                map.put("id", uuid.toString());

                logger.error("{} API call error [{}]", uuid, msg, e);

                return Response.status(status).entity(map).type(MediaType.APPLICATION_JSON_TYPE).build();
            }
    }
