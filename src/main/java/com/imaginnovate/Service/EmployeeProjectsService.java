package com.imaginnovate.Service;

import java.util.List;

import com.imaginnovate.Dto.EmployeeProjectsDto;
import com.imaginnovate.Entities.EmployeeProjects;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Repository.EmployeeProjectsRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeProjectsService {

    @Inject
    EmployeeProjectsRepo employeeProjectsRepo;

    public List<EmployeeProjectsDto> findAllEmployeeProjects() {
        List<EmployeeProjectsDto> results = findAllEmployeeProjects();
        return results;
    }

    @Transactional
    public EmployeeProjects createEmployeeProjects(EmployeeProjectsDto employeeProjectsDto) {
        EmployeeProjects employeeProjects = new EmployeeProjects();

        employeeProjects.setId(employeeProjectsDto.getId());
        if (employeeProjectsDto.getEmployee() != 0) {
            Employees employees = Employees.findById(employeeProjectsDto.getEmployee());
            if (employees !=null) {
                employeeProjects.employee = employees;
            }else {
                throw new IllegalArgumentException("Employee with ID " + employeeProjectsDto.getEmployee() + " not found");
            }
        }


        if (employeeProjectsDto.getProject() != 0) {
            Projects projects = Projects.findById(employeeProjectsDto.getProject());
            if (projects !=null) {
                employeeProjects.project = projects;
            }else {
                throw new IllegalArgumentException("Project with ID " + employeeProjectsDto.getProject()+ " not found");
            }
        }
        employeeProjects.canApproveTimesheets = employeeProjectsDto.getCanApproveTimesheets();

        employeeProjectsRepo.persist(employeeProjects);
        return employeeProjects;
    }

    public EmployeeProjectsDto getEmployeeProjectById(int id) {
        EmployeeProjects ep = employeeProjectsRepo.findById(id);
        if (ep == null) {
            return null;
        }
        EmployeeProjectsDto dto = new EmployeeProjectsDto();
        dto.setId(ep.getId());
        dto.setEmployee(ep.employee.getId());
        dto.setProject(ep.project.getId());
        dto.setCanApproveTimesheets(ep.canApproveTimesheets);
        dto.setCreatedBy(ep.createdBy);
            dto.setCreated_On(ep.created_On);
            if (ep.deletedBy != null) {
                dto.setDeletedBy(ep.deletedBy);
            }
            dto.setDeletedOn(ep.deletedOn);
            if (ep.modifiedBy != null) {
                dto.setModifiedBy(ep.modifiedBy);
            }
            dto.setModifiedOn(ep.modifiedOn);

        return dto;
    }
}

