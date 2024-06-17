package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.TaskDto;
import com.imaginnovate.Service.TaskService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tasks")
public class TaskController {
    @Inject
    TaskService taskService;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TaskDto> alltasks() {
    List<TaskDto> results = taskService.getAllTasks();
    return results;
    }



    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        TaskDto task = taskService.getTaskById(id);
        if (task == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Task not found for ID: " + id).build();
        }
        return Response.ok(task).build();
    }
    }
    

