package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.ProjectDto;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Service.ProjectsService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/projects")
public class ProjectController {
    @Inject
    ProjectsService projectsService;

    @GET
    @Path("/getall")
    public List<ProjectDto> getallprojects() {
        List<ProjectDto> results = projectsService.getAllProjects();
        return results;
    }

    @POST
    @Path("/add")
    @Transactional
    public Response createProject(ProjectDto projectDto) {
        Projects projects = projectsService.createProject(projectDto);
        return Response.status(Response.Status.CREATED).entity(projects).build();
    }

    @GET
    @Path("/get/{id}")
    public Response getById(@PathParam("id") int id) {
        ProjectDto dto = projectsService.getProjectById(id);
        if (dto == null) {
            return Response.status(Response.Status.NOT_FOUND)
                           .entity("Project not found for ID: " + id)
                           .build();
        }
        return Response.ok(dto).build();
    }
    }

