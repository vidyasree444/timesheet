package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Entities.Timesheets;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimesheetRepo implements PanacheRepositoryBase<Timesheets,Integer> {
    public List<TimesheetDto> findAllTimesheets() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.TimesheetDto(t.id, t.employeeProject.id, t.projectTask.id, t.description, t.hoursWorked, t.submittedBy.id, t.submittedOn, t.status.id, t.approvedBy.id, t.createdBy, t.created_On, t.modifiedBy, t.modifiedOn, t.deletedBy, t.deletedOn) FROM Timesheets t",
            TimesheetDto.class)
            .getResultList();
    }
}
