package com.imaginnovate.Service;


import java.util.List;

import com.imaginnovate.Dto.TaskDto;
import com.imaginnovate.Entities.Tasks;
import com.imaginnovate.Repository.TasksRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class TaskService {
     @Inject
    TasksRepo tasksRepo;

    public List<TaskDto> getAllTasks() {
     return tasksRepo.findAllTasks();
    }

    



    public TaskDto getTaskById(int id) {
        Tasks e=tasksRepo.findById(id);
        if (e == null) {
            return null;
        }
        TaskDto dto=new TaskDto();
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
   
    

