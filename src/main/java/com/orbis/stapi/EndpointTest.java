package com.orbis.stapi;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/v1/test")
@Produces(MediaType.APPLICATION_JSON)
public class EndpointTest
    {
        @GET
        @Path("/date")
        @InsecureCall
        public BasicResponse getDate()
            {
                return BasicResponse.Success().setContents(new Date());
            }
    }
