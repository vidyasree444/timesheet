package com.imaginnovate.Service;


import java.util.List;

import com.imaginnovate.Dto.ProjectDto;
import com.imaginnovate.Entities.Divisions;
import com.imaginnovate.Entities.Projects;
import com.imaginnovate.Repository.DivisionsRepo;
import com.imaginnovate.Repository.ProjectsRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class ProjectsService {
    @Inject
    ProjectsRepo projectsRepo;

    @Inject
    DivisionsRepo divisionsRepo;

    public List<ProjectDto> getAllProjects() {
        return projectsRepo.findAllProjects();
    }
   

    @Transactional
    public Projects createProject(ProjectDto projectDto) {
        Projects projects = new Projects();
        projects.setId(projectDto.getId());
        projects.name = projectDto.getName();
        projects.description = projectDto.getDescription();

        if (projectDto.getDivision() != 0) {
            Divisions divisions = Divisions.findById(projectDto.getDivision());
            if (divisions !=null) {
                projects.division = divisions;
            }
            else {
                throw new IllegalArgumentException("Division with ID " + projectDto.getDivision() + " not found");
            }
        }

        projectsRepo.persist(projects);
        return projects;
    }

    public ProjectDto getProjectById(int id) {
        Projects projects = projectsRepo.findById(id);
        if (projects == null) {
            return null;
        }
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(projects.getId());
        projectDto.setName(projects.name);
        projectDto.setDescription(projects.description);
        if (projects.division != null) {
            projectDto.setDivision(projects.division.getId());
        }
        projectDto.setCreatedBy(projects.createdBy);
           projectDto.setCreated_On(projects.created_On);
            if (projects.deletedBy != null) {
                projectDto.setDeletedBy(projects.deletedBy);
            }
            projectDto.setDeletedOn(projects.deletedOn);
            if (projects.modifiedBy != null) {
               projectDto.setModifiedBy(projects.modifiedBy);
            }
            projectDto.setModifiedOn(projects.modifiedOn);
        return projectDto;
    }
}
