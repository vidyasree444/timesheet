package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.UsersDto;
import com.imaginnovate.Entities.Users;
import com.imaginnovate.Service.UserService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserController {
    @Inject
    UserService usersService;
    @GET
    @Path("/getall")
    public List<UsersDto> getAllUsers() {
        return usersService.getAllUsers();
    }
    @POST
    @Path("/add")
    @Transactional
    public Response addUser(UsersDto usersDto) {
        Users newUser = usersService.addUser(usersDto);
        return Response.status(Response.Status.CREATED).entity(newUser).build();
    }
    @GET
    @Path("/get/{id}")
    public Response getUserById(@PathParam("id") int id) {
        UsersDto usersDto = usersService.getUserById(id);
        if (usersDto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usersDto).build();
    }

}
