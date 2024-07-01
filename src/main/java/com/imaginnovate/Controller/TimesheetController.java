package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Service.TimesheetService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTimesheet(TimesheetDto timesheetDto) {
        try {
            TimesheetDto createdTimesheet = timesheetService.createTimesheet(timesheetDto);
            return Response.status(Response.Status.CREATED).entity(createdTimesheet).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
}
    @PUT
    @Path("/approve/division/{divisionId}/approver/{approverId}")
    public Response approveTimesheetsForDivision(@PathParam("divisionId") int divisionId, @PathParam("approverId") int approverId) {
        try {
            timesheetService.approveTimesheetsForDivision(divisionId, approverId);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/approve/project/{projectId}/approver/{approverId}")
    public Response approveTimesheetsForProject(@PathParam("projectId") int projectId, @PathParam("approverId") int approverId) {
        try {
            timesheetService.approveTimesheetsForProject(projectId, approverId);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/approve/project/{projectId}/manager/{managerId}/approver/{approverId}")
    public Response approveTimesheetsForManager(@PathParam("projectId") int projectId, @PathParam("managerId") int managerId, @PathParam("approverId") int approverId) {
        try {
            timesheetService.approveTimesheetsForManager(projectId, managerId, approverId);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
