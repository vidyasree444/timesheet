package com.imaginnovate.Dto;

import java.time.LocalDateTime;

public class EmployeeProjectsDto {
    
    private Integer id;
    private Integer employee;
    private Integer project;
    private Boolean canApproveTimesheets;
    private Integer createdBy;
    private LocalDateTime created_On;
    private Integer modifiedBy;
    private LocalDateTime modifiedOn;
    private Integer deletedBy;
    private LocalDateTime deletedOn;

    public EmployeeProjectsDto() {
     }


    public EmployeeProjectsDto(Integer id, Integer employee, Integer project, Boolean canApproveTimesheets, Integer createdBy, LocalDateTime created_On, Integer modifiedBy, LocalDateTime modifiedOn, Integer deletedBy, LocalDateTime deletedOn) {
        this.id = id;
        this.employee = employee;
        this.project = project;
        this.canApproveTimesheets = canApproveTimesheets;
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

    public Integer getEmployee() {
        return this.employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public Integer getProject() {
        return this.project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Boolean isCanApproveTimesheets() {
        return this.canApproveTimesheets;
    }

    public Boolean getCanApproveTimesheets() {
        return this.canApproveTimesheets;
    }

    public void setCanApproveTimesheets(Boolean canApproveTimesheets) {
        this.canApproveTimesheets = canApproveTimesheets;
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

    public EmployeeProjectsDto id(Integer id) {
        setId(id);
        return this;
    }

    public EmployeeProjectsDto employee(Integer employee) {
        setEmployee(employee);
        return this;
    }

    public EmployeeProjectsDto project(Integer project) {
        setProject(project);
        return this;
    }

    public EmployeeProjectsDto canApproveTimesheets(Boolean canApproveTimesheets) {
        setCanApproveTimesheets(canApproveTimesheets);
        return this;
    }

    public EmployeeProjectsDto createdBy(Integer createdBy) {
        setCreatedBy(createdBy);
        return this;
    }

    public EmployeeProjectsDto created_On(LocalDateTime created_On) {
        setCreated_On(created_On);
        return this;
    }

    public EmployeeProjectsDto modifiedBy(Integer modifiedBy) {
        setModifiedBy(modifiedBy);
        return this;
    }

    public EmployeeProjectsDto modifiedOn(LocalDateTime modifiedOn) {
        setModifiedOn(modifiedOn);
        return this;
    }

    public EmployeeProjectsDto deletedBy(Integer deletedBy) {
        setDeletedBy(deletedBy);
        return this;
    }

    public EmployeeProjectsDto deletedOn(LocalDateTime deletedOn) {
        setDeletedOn(deletedOn);
        return this;
    }
}

  
      

       