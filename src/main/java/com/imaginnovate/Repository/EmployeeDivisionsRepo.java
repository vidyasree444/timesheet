package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.EmployeeDivisionsDto;
import com.imaginnovate.Entities.EmployeeDivisions;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EmployeeDivisionsRepo implements PanacheRepositoryBase<EmployeeDivisions,Integer>{
    public List<EmployeeDivisionsDto> findAllEmployeeDivisions() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.EmployeeDivisionsDto(e.id, e.employee.id, e.division.id, e.canApproveTimesheets, e.createdBy, e.created_On, e.modifiedBy, e.modifiedOn, e.deletedBy, e.deletedOn) FROM EmployeeDivisions e",
            EmployeeDivisionsDto.class)
            .getResultList();
    }
}
