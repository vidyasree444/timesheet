package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.TaskDto;
import com.imaginnovate.Entities.Tasks;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TasksRepo implements PanacheRepositoryBase<Tasks,Integer> {
    public List<TaskDto> findAllTasks() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.TaskDto(t.id, t.name, t.description, t.createdBy, t.created_On, t.modifiedBy, t.modifiedOn, t.deletedBy, t.deletedOn) FROM Tasks t",
            TaskDto.class)
            .getResultList();
    }

}