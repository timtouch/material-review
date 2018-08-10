package com.revature.controller;

import com.revature.beans.Bear;
import com.revature.beans.Cave;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("/caves")
public class CaveController extends Application
{
    private List<Cave> caves;

    public CaveController (){
        caves = new ArrayList<>();
        caves.add(new Cave (1, "Cave 1", 4));
        caves.add(new Cave (2, "Cave 2", 5));
        caves.add(new Cave (3, "Cave 3", 2));

    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cave> getAllCaves(){
        return caves;
    }

    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello(){
        return "Hello";
    }

    @GET
    @Path("/{caveid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cave returnCaveById(@PathParam("caveid") String caveid) {
        Cave returnCave = null;
        for (Cave c: caves){
            if (c.getId() == Integer.parseInt(caveid)){
                returnCave = c;
            }
        }
        return returnCave;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveCave(Cave c){
        caves.add(c);
        System.out.println(c.getName());
        System.out.println(caves);
        return Response.status(200).build();
    }
}
