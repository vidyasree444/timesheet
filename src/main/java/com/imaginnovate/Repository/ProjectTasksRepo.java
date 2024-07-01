package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.ProjectTasksDto;
import com.imaginnovate.Entities.ProjectTasks;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProjectTasksRepo implements PanacheRepositoryBase<ProjectTasks,Integer> {
    public List<ProjectTasksDto> findAllProjects() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.ProjectTasksDto(pt.id, pt.project.id, pt.task.id, pt.createdBy, pt.created_On, pt.modifiedBy, pt.modifiedOn, pt.deletedBy, pt.deletedOn) FROM ProjectTasks pt",
            ProjectTasksDto.class)
            .getResultList();
}
}
