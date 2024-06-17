package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.DivisionsDto;
import com.imaginnovate.Service.DivisionService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Divisons")
public class DivisionController {

    @Inject
    DivisionService divisionService;


    @GET
    @Path("/All")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DivisionsDto> getAllDivisions() {
        List<DivisionsDto> results = divisionService.getAllProjections();
        
        // Place a breakpoint here
        return results;
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createDivision(DivisionsDto divisionsDto) {
        DivisionsDto createdDivision = divisionService.createDivision(divisionsDto);
        return Response.status(Response.Status.CREATED).entity(createdDivision).build();
    }
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DivisionsDto getById(@PathParam("id") int id) {
        return divisionService.getDivisionById(id);
    }
    

}