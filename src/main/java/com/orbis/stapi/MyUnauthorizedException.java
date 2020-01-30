package com.orbis.stapi;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.apache.logging.log4j.*;

/**
 * User: Daniil Sosonkin
 * Date: 9/5/2018 10:49 AM
 */
public class MyUnauthorizedException extends WebApplicationException
    {
        public MyUnauthorizedException(String message)
            {
                super(message, Response.status(Response.Status.UNAUTHORIZED).build());
                LogManager.getLogger(getClass()).error("Error: {}", message);
            }
    }
