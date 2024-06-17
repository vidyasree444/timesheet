package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.EmployeeProjectsDto;
import com.imaginnovate.Entities.EmployeeProjects;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class EmployeeProjectsRepo implements PanacheRepositoryBase<EmployeeProjects,Integer> {
   
   
    public List<EmployeeProjectsDto> findAllEmployeeProjects() {
        return getEntityManager().createQuery(
                "SELECT new com.imaginnovate.Dto.EmployeeProjectsDto(ep.id, ep.employee.id, ep.project.id, ep.canApproveTimesheets, ep.createdBy, ep.created_On, ep.modifiedBy, ep.modifiedOn, ep.deletedBy, ep.deletedOn) FROM EmployeeProjects ep",
                EmployeeProjectsDto.class)
                .getResultList();
    }
}

