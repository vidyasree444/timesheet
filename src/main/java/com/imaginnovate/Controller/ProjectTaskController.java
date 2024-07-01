package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.ProjectTasksDto;
import com.imaginnovate.Entities.ProjectTasks;
import com.imaginnovate.Service.ProjectTasksService;

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


@Path("/project-task")
public class ProjectTaskController {
    
    @Inject
    ProjectTasksService projectTasksService;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectTasksDto> all() {
        List<ProjectTasksDto> results = projectTasksService.getAllProjectTasks();
        return results;
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createProjectTask(ProjectTasksDto projectTasksDto) {
        ProjectTasks projectTasks=projectTasksService.createProjectTask(projectTasksDto);
        return Response.status(Response.Status.CREATED).entity(projectTasks).build();
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        ProjectTasksDto dto = projectTasksService.getProjectTaskById(id);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Project task not found for ID: " + id).build();
        }
        return Response.ok(dto).build();
    }


    


}

