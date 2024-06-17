package com.imaginnovate.Service;

import java.util.List;

import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Entities.Timesheets;
import com.imaginnovate.Repository.TimesheetRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TimesheetService {
    @Inject
    TimesheetRepo timesheetRepo;

    public List<TimesheetDto> getAllTimesheets() {
        return timesheetRepo.findAllTimesheets();
    }

    public TimesheetDto getTimesheetById(int id) {
        Timesheets d = timesheetRepo.findById(id);
        if (d == null) {
            return null;
        }
        TimesheetDto fhd = new TimesheetDto();
        fhd.setId(d.getId());
        fhd.setEmployeeProject(d.getEmployeeProject().getId());
        fhd.setProjectTask(d.getProjectTask().getId());
        fhd.setDescription(d.getDescription());
        fhd.setHoursWorked(d.getHoursWorked());
        fhd.setSubmittedBy(d.getSubmittedBy().getId());
        fhd.setSubmittedOn(d.getSubmittedOn());
        fhd.setStatus(d.getStatus().getId());
        if (d.getApprovedBy() != null) {
            fhd.setApprovedBy(d.getApprovedBy().getId());
        }
        fhd.setCreatedBy(d.createdBy);
        fhd.setCreated_On(d.created_On);
        if (d.deletedBy != null) {
            fhd.setDeletedBy(d.deletedBy);
        }
        fhd.setDeletedOn(d.deletedOn);
        if (d.modifiedBy != null) {
            fhd.setModifiedBy(d.modifiedBy);
        }
        fhd.setModifiedOn(d.modifiedOn);
        return fhd;
    }
}
