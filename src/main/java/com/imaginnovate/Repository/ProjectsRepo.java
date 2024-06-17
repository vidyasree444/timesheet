package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.ProjectDto;
import com.imaginnovate.Entities.Projects;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProjectsRepo implements PanacheRepositoryBase<Projects,Integer> {
    
    public List<ProjectDto> findAllProjects() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.ProjectDto(p.id, p.name, p.description, p.division.id, p.createdBy, p.created_On, p.modifiedBy, p.modifiedOn, p.deletedBy, p.deletedOn) FROM Projects p",
            ProjectDto.class)
            .getResultList();
    }
}

