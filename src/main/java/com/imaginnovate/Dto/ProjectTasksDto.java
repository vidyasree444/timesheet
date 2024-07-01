package com.imaginnovate.Dto;

import java.time.LocalDateTime;

public class ProjectTasksDto {
    private Integer id;

    private Integer project;

    private Integer task;

    private Integer createdBy;

    private LocalDateTime created_On;

    private Integer modifiedBy;

    private LocalDateTime modifiedOn;

    private Integer deletedBy;
    
    private LocalDateTime deletedOn;

    public ProjectTasksDto() {
    }

    

    public ProjectTasksDto(Integer id, Integer project, Integer task, Integer createdBy, LocalDateTime created_On, Integer modifiedBy, LocalDateTime modifiedOn, Integer deletedBy, LocalDateTime deletedOn) {
        this.id = id;
        this.project = project;
        this.task = task;
        this.createdBy = createdBy;
        this.created_On = created_On;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
        this.deletedBy = deletedBy;
        this.deletedOn = deletedOn;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProject() {
        return this.project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getTask() {
        return this.task;
    }

    public void setTask(Integer task) {
        this.task = task;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreated_On() {
        return this.created_On;
    }

    public void setCreated_On(LocalDateTime created_On) {
        this.created_On = created_On;
    }

    public Integer getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedOn() {
        return this.modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Integer getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getDeletedOn() {
        return this.deletedOn;
    }

    public void setDeletedOn(LocalDateTime deletedOn) {
        this.deletedOn = deletedOn;
    }

    

}
