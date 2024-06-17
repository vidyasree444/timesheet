
package com.imaginnovate.Service;
import java.util.ArrayList;
import java.util.List;

import com.imaginnovate.Dto.TimesheetStatusDto;
import com.imaginnovate.Entities.TimesheetStatus;
import com.imaginnovate.Repository.TimesheetStatusRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TimesheetStatusService {

    @Inject
    TimesheetStatusRepo timesheetStatusRepo;

    public List<TimesheetStatusDto> getAllTimesheetStatus() {
        List<TimesheetStatus>timesheetStatus= timesheetStatusRepo.listAll();
    
        List<TimesheetStatusDto> timesheetStatusDtos = new ArrayList<>();
        for (TimesheetStatus e : timesheetStatus) {
            TimesheetStatusDto dto=new TimesheetStatusDto();
            dto.setId(e.getId());
            dto.setName(e.name);
            dto.setCreatedBy(e.createdBy);
            dto.setCreated_On(e.created_On);
            if (e.deletedBy != null) {
                dto.setDeletedBy(e.deletedBy);
            }
            dto.setDeletedOn(e.deletedOn);
            if (e.modifiedBy != null) {
                dto.setModifiedBy(e.modifiedBy);
            }
            dto.setModifiedOn(e.modifiedOn);
            timesheetStatusDtos.add(dto);
        }
        return timesheetStatusDtos;
    }


    public TimesheetStatusDto getTimesheetStatusById(int id) {
        TimesheetStatus e= timesheetStatusRepo.findById(id);
        if (e == null) {
            return null;
        }
        TimesheetStatusDto dto=new TimesheetStatusDto();
            dto.setId(e.getId());
            dto.setName(e.name);
            dto.setCreatedBy(e.createdBy);
            dto.setCreated_On(e.created_On);
            if (e.deletedBy != null) {
                dto.setDeletedBy(e.deletedBy);
            }
            dto.setDeletedOn(e.deletedOn);
            if (e.modifiedBy != null) {
                dto.setModifiedBy(e.modifiedBy);
            }
            dto.setModifiedOn(e.modifiedOn);
            return dto;
    }
}
