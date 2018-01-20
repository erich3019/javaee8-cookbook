package com.eldermoraes.ch08.micro_x_mono.micro.user.entity.service;

import com.eldermoraes.ch08.micro_x_mono.micro.user.entity.User;
import com.eldermoraes.ch08.micro_x_mono.micro.user.entity.bean.UserBeanMock;
import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author eldermoraes
 */
@Path("userService")
public class UserService {
    
    @EJB
    private UserBeanMock userBean;
    
    private final Jsonb jsonbBuilder = JsonbBuilder.create();
    
    @GET
    @Path("findById/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        return Response.ok(jsonbBuilder.toJson(userBean.findById(id))).build();
    }
    
    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        return Response.ok(jsonbBuilder.toJson(userBean.get())).build();
    }    
    
    @PUT
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response add(User user){
        userBean.add(user);
        return Response.accepted().build();
    }    
    
    @DELETE
    @Path("remove/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)    
    public Response remove(@PathParam("id") Long id){
        userBean.remove(userBean.findById(id));
        return Response.accepted().build();
    }
    
}
