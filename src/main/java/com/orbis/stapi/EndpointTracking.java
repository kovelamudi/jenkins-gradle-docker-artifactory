package com.orbis.stapi;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/v2/tracking")
@Produces(MediaType.APPLICATION_JSON)
public class EndpointTracking
    {
        @POST
        @Path("/add")
        @Consumes(MediaType.APPLICATION_JSON)
        public BasicResponse add(TrackingEntry entry)
            {
                TrackerStorage storage = TrackerStorage.getInstance();
                storage.add(entry);

                return BasicResponse.Success();
            }
    }
