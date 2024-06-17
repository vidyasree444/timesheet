package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Service.TimesheetService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Timesheet")
public class TimesheetController {

    @Inject
    TimesheetService timesheetService;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TimesheetDto> getall() {
        List<TimesheetDto> results = timesheetService.getAllTimesheets();
        return results;
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        TimesheetDto timesheet = timesheetService.getTimesheetById(id);
        if (timesheet == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(timesheet).build();
    }
}