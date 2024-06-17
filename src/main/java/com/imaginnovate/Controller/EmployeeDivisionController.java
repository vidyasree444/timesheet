package com.imaginnovate.Controller;


import java.util.List;
import com.imaginnovate.Dto.EmployeeDivisionsDto;
import com.imaginnovate.Entities.EmployeeDivisions;
import com.imaginnovate.Service.EmployeeDivisionService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/employeeDivisions")
public class EmployeeDivisionController {

    @Inject
    EmployeeDivisionService employeeDivisionService;

    @GET
    @Path("/all")
    public List<EmployeeDivisionsDto> getAllEmployeeDivisions() {
        List<EmployeeDivisionsDto> results = employeeDivisionService.findAllEmployeeDivisions();
        return results;
    }

    @POST
    @Path("/add")
    @Transactional
    public Response createProjectTask(EmployeeDivisionsDto employeeDivisionsDto) {
        EmployeeDivisions employeeDivisions = employeeDivisionService.createEmployeeDivision(employeeDivisionsDto);
        return Response.status(Response.Status.CREATED).entity(employeeDivisions).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getById(@PathParam("id") int id) {
        EmployeeDivisionsDto dto = employeeDivisionService.getEmployeeDivisionById(id);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("EmployeeDivision not found for ID: " + id)
                           .build();
        }
        return Response.ok(dto).build();
    }

    
}
