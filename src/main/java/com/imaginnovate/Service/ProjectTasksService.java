package com.imaginnovate.Service;


import java.util.List;

import com.imaginnovate.Dto.ProjectTasksDto;
import com.imaginnovate.Entities.ProjectTasks;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Entities.Tasks;
import com.imaginnovate.Repository.ProjectTasksRepo;
import com.imaginnovate.Repository.ProjectsRepo;
import com.imaginnovate.Repository.TasksRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProjectTasksService {
    @Inject
    ProjectTasksRepo projectTasksRepo;

    @Inject
    ProjectsRepo projectsRepo;

    @Inject
    TasksRepo tasksRepo;

    public List<ProjectTasksDto> getAllProjectTasks() {
        return  projectTasksRepo.findAllProjects();
    }

    @Transactional
    public ProjectTasks createProjectTask(ProjectTasksDto projectTasksDto) {
        ProjectTasks projectTasks = new ProjectTasks();

        projectTasks.setId(projectTasksDto.getId());
        if (projectTasksDto.getProject() != 0) {
            Projects projects = Projects.findById(projectTasksDto.getProject());
            if (projects!=null) {
                projectTasks.project = projects;
            }else {
                throw new IllegalArgumentException("Project with ID " + projectTasksDto.getProject() + " not found");
            }
        }

        if (projectTasksDto.getTask() != 0) {
            Tasks tasks = Tasks.findById(projectTasksDto.getTask());
            if (tasks!=null) {
                projectTasks.task = tasks;
            }else {
                throw new IllegalArgumentException("Task with ID " + projectTasksDto.getTask() + " not found");
            }
        }

        projectTasksRepo.persist(projectTasks);
        return projectTasks;
    }

    public ProjectTasksDto getProjectTaskById(int id) {
        ProjectTasks projectTasks = projectTasksRepo.findById(id);
        if (projectTasks == null) {
            return null;
        }
        ProjectTasksDto dto = new ProjectTasksDto();
        dto.setId(projectTasks.getId());
        dto.setProject(projectTasks.project.getId());
        dto.setTask(projectTasks.task.getId());
        dto.setCreatedBy(projectTasks.createdBy);
            dto.setCreated_On(projectTasks.created_On);
            if (projectTasks.deletedBy != null) {
                dto.setDeletedBy(projectTasks.deletedBy);
            }
            dto.setDeletedOn(projectTasks.deletedOn);
            if (projectTasks.modifiedBy != null) {
                dto.setModifiedBy(projectTasks.modifiedBy);
            }
            dto.setModifiedOn(projectTasks.modifiedOn);

        return dto;
    }
}
