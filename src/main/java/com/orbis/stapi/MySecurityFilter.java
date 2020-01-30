package com.orbis.stapi;

import java.lang.reflect.*;
import javax.annotation.*;
import javax.ws.rs.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

/**
 * User: Daniil Sosonkin
 * Date: 9/5/2018 9:56 AM
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class MySecurityFilter implements ContainerRequestFilter
    {
        @Context
        private ResourceInfo resource;

        @Context
        private Request request;

        @Context
        private HttpHeaders headers;

        @Override
        public void filter(ContainerRequestContext context)
            {
                Method method = resource.getResourceMethod();

                if (method.isAnnotationPresent(InsecureCall.class))
                    return;

                String auth = headers.getHeaderString("Authorization");
                int pos = (auth == null ? -1 : auth.indexOf(' '));
                if (pos == -1)
                    throw new MyUnauthorizedException("Authorization header is missing");

                String authType = auth.substring(0, pos);
                if (!"Bearer".equals(authType))
                    throw new MyUnauthorizedException("Invalid credentials");

                String payload = auth.substring(pos + 1);
                Server server = Server.getInstance();

                if (!server.getSettings().getKeys().contains(payload))
                    throw new MyUnauthorizedException("Invalid credentials");
            }
    }
