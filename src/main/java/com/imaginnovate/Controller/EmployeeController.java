package com.imaginnovate.Controller;

import java.util.List;

import com.imaginnovate.Dto.EmployeeDto;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Service.EmployeeService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeController {

    @Inject
    EmployeeService employeeService;


    @GET
    @Path("/All")
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto>  results=employeeService.getAllEmployees();
        return  results;
    }
    @POST
    @Path("/add")
    @Transactional
    public Employees addEmployee(EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @GET
    @Path("/get/{id}")
    public EmployeeDto getById(@PathParam("id") int id) {
        return employeeService.getEmployeeById(id);
    }
    }

