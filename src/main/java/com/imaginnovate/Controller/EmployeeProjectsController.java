package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.EmployeeProjectsDto;
import com.imaginnovate.Entities.EmployeeProjects;
import com.imaginnovate.Service.EmployeeProjectsService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/employee-projects")
public class EmployeeProjectsController {
    @Inject
    EmployeeProjectsService employeeProjectsService;

    @GET
    @Path("/getall")
    public List<EmployeeProjectsDto> getallemployeeprojects() {
        List<EmployeeProjectsDto> results = employeeProjectsService.findAllEmployeeProjects();
        return results;
    }

    @POST
    @Path("/add")
    @Transactional
    public Response createEmployeeProjects(EmployeeProjectsDto employeeProjectsDto) {
        EmployeeProjects employeeProjects = employeeProjectsService.createEmployeeProjects(employeeProjectsDto);
        return Response.status(Response.Status.CREATED).entity(employeeProjects).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getById(@PathParam("id") int id) {
        EmployeeProjectsDto dto = employeeProjectsService.getEmployeeProjectById(id);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Employee project not found for ID: " + id)
                           .build();
        }
        return Response.ok(dto).build();
    }
}
