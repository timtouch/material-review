package com.revature.controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@Path("/rest")
@ApplicationPath("/api")
public class RestControlller extends Application
{
    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello";
    }

}
