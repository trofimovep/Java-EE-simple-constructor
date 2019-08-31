package com.resources;

import com.service.ServerService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ServerResources {

    @Inject
    ServerService service = new ServerService();
    
    @Path("message")
    @GET
    public Response changeMessages(@QueryParam("message") String message) {

        return Response.ok(service.changeMessages(message)).build();
    }


    @Path("dto")
    @GET
    public Response changeMessages(@QueryParam("id") long id) {
        return Response.ok(service.getExanpleDto(id)).build();
    }

}
