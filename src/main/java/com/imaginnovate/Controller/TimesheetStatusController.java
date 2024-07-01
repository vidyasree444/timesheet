package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.TimesheetStatusDto;
import com.imaginnovate.Service.TimesheetService;
import com.imaginnovate.Service.TimesheetStatusService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/timesheetstatus")
public class TimesheetStatusController {
    @Inject
    TimesheetStatusService timesheetStatusService;

    @Inject
    TimesheetService timesheetService;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TimesheetStatusDto> all() {
        List<TimesheetStatusDto> results = timesheetStatusService.getAllTimesheetStatus();
        return results;
    }

    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TimesheetStatusDto getById(@PathParam("id") Byte id) {
        return timesheetStatusService.getTimesheetStatusById(id);
    }

    

}
