package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.EmployeeDto;
import com.imaginnovate.Entities.Employees;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeesRepo implements PanacheRepositoryBase<Employees,Integer> {
    public List<EmployeeDto> findAllProjections() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.EmployeeDto(e.id, e.firstName, e.lastName, e.gender, e.email, e.designation, e.startDate, e.endDate, e.division.id, e.reports_to.id, e.createdBy, e.created_On, e.modifiedBy, e.modifiedOn, e.deletedBy, e.deletedOn) FROM Employees e",
            EmployeeDto.class)
            .getResultList();
    }
}
