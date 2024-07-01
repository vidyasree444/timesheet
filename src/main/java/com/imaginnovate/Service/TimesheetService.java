package com.imaginnovate.Service;


import java.util.List;

import com.imaginnovate.Dto.EmployeeProjectsDto;
import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Entities.EmployeeProjects;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Entities.ProjectTasks;
import com.imaginnovate.Entities.TimesheetStatus;
import com.imaginnovate.Entities.Timesheets;
import com.imaginnovate.Repository.EmployeeProjectsRepo;
import com.imaginnovate.Repository.EmployeesRepo;
import com.imaginnovate.Repository.ProjectTasksRepo;
import com.imaginnovate.Repository.TimesheetRepo;
import com.imaginnovate.Repository.TimesheetStatusRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TimesheetService {
    @Inject
    TimesheetRepo timesheetRepo;

    @Inject
    EmployeeProjectsRepo employeeProjectsRepo;

    @Inject
    ProjectTasksRepo projectTasksRepo;

    @Inject
    EmployeesRepo employeesRepo;

    @Inject
    TimesheetStatusRepo timesheetStatusRepo;

    @Inject
    EmployeeProjectsDto employeeProjectsDto;

    public List<TimesheetDto> getAllTimesheets() {
        List<TimesheetDto> results = timesheetRepo.findAllTimesheets();
        return results;
    }

    public TimesheetDto getTimesheetById(int id) {
        Timesheets d = timesheetRepo.findById(id);
        if (d == null) {
            return null;
        }
        return mapTimesheetToDto(d);
    }

    @Transactional
    public TimesheetDto createTimesheet(TimesheetDto timesheetDto) {
        // Fetch related entities
        EmployeeProjects employeeProject = employeeProjectsRepo.findById(timesheetDto.getEmployeeProject());
        if (employeeProject == null) {
            throw new IllegalArgumentException("Employee project with ID " + timesheetDto.getEmployeeProject() + " not found");
        }

        ProjectTasks projectTask = projectTasksRepo.findById(timesheetDto.getProjectTask());
        if (projectTask == null) {
            throw new IllegalArgumentException("Project task with ID " + timesheetDto.getProjectTask() + " not found");
        }

        Employees submittedBy = employeesRepo.findById(timesheetDto.getSubmittedBy());
        if (submittedBy == null) {
            throw new IllegalArgumentException("Employee with ID " + timesheetDto.getSubmittedBy() + " not found");
        }

        TimesheetStatus status = timesheetStatusRepo.findById(timesheetDto.getStatus());
        if (status == null) {
            throw new IllegalArgumentException("Timesheet status with ID " + timesheetDto.getStatus() + " not found");
        }

        Timesheets timesheet = new Timesheets();
        timesheet.employeeProject = employeeProject;
        timesheet.projectTask = projectTask;
        timesheet.description = timesheetDto.getDescription();
        timesheet.hoursWorked = timesheetDto.getHoursWorked();
        timesheet.submittedBy = submittedBy;
        timesheet.submittedOn = timesheetDto.getSubmittedOn();
        timesheet.status = status;

        if (timesheetDto.getApprovedBy() != null) {
            Employees approvedBy = employeesRepo.findById(timesheetDto.getApprovedBy());
            if (approvedBy == null) {
                throw new IllegalArgumentException("Employee with ID " + timesheetDto.getApprovedBy() + " not found");
            }
            timesheet.approvedBy = approvedBy;
        }
        timesheet.createdBy = timesheetDto.getCreatedBy();
        timesheet.created_On = timesheetDto.getCreated_On();
        timesheet.modifiedBy = timesheetDto.getModifiedBy();
        timesheet.modifiedOn = timesheetDto.getModifiedOn();
        timesheet.deletedBy = timesheetDto.getDeletedBy();
        timesheet.deletedOn = timesheetDto.getDeletedOn();
        timesheet.persist();
        timesheetDto.setId(timesheet.getId());
        return timesheetDto;
    }

    private TimesheetDto mapTimesheetToDto(Timesheets timesheet) {
        TimesheetDto dto = new TimesheetDto();
        dto.setId(timesheet.getId());
        dto.setEmployeeProject(timesheet.employeeProject.getId());
        dto.setProjectTask(timesheet.projectTask.getId());
        dto.setDescription(timesheet.description);
        dto.setHoursWorked(timesheet.hoursWorked);
        dto.setSubmittedBy(timesheet.submittedBy.getId());
        dto.setSubmittedOn(timesheet.submittedOn);
        dto.setStatus(timesheet.status.getId());

        if (timesheet.approvedBy != null) {
            dto.setApprovedBy(timesheet.approvedBy.getId());
        }
        dto.setCreatedBy(timesheet.createdBy);
        dto.setCreated_On(timesheet.created_On);
        dto.setModifiedBy(timesheet.modifiedBy);
        dto.setModifiedOn(timesheet.modifiedOn);
        dto.setDeletedBy(timesheet.deletedBy);
        dto.setDeletedOn(timesheet.deletedOn);
        return dto;
    }

    @Transactional
    public void approveTimesheetsForDivision(int divisionId, int approverId) {
        timesheetRepo.updateTimesheetStatusForDivision(divisionId, approverId);
    }

    @Transactional
    public void approveTimesheetsForProject(int projectId, int approverId) {
        timesheetRepo.updateTimesheetStatusForProject(projectId, approverId);
    }

    @Transactional
    public void approveTimesheetsForManager(int projectId, int managerId, int approverId) {
        timesheetRepo.updateTimesheetStatusForManager(projectId, managerId, approverId);
    }

}