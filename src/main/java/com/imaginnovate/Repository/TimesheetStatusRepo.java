package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.TimesheetStatusDto;
import com.imaginnovate.Entities.TimesheetStatus;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TimesheetStatusRepo implements PanacheRepositoryBase<TimesheetStatus,Byte>{
    public List<TimesheetStatusDto> findAllTimesheets() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.TimesheetStatusDto(ts.id, ts.name, ts.createdBy, ts.created_On, ts.modifiedBy, ts.modifiedOn, ts.deletedBy, ts.deletedOn) FROM TimesheetStatusDto ts",
            TimesheetStatusDto.class)
            .getResultList();
    }
}
