package com.imaginnovate.Dto;

import java.time.LocalDateTime;

public class TimesheetDto {

    private Integer id;

    private Integer employeeProject;

    private Integer projectTask;

    private String description;

    private Short hoursWorked;

    private Integer submittedBy;

    private LocalDateTime submittedOn;

    private Byte status;

    private Integer approvedBy;

    private Integer createdBy;

    private LocalDateTime created_On;

    private Integer modifiedBy;

    private LocalDateTime modifiedOn;

    private Integer deletedBy;

    private LocalDateTime deletedOn;

    public TimesheetDto() {
    }

  


    public TimesheetDto(Integer id, Integer employeeProject, Integer projectTask, String description, Short hoursWorked, Integer submittedBy, LocalDateTime submittedOn, Byte status, Integer approvedBy, Integer createdBy, LocalDateTime created_On, Integer modifiedBy, LocalDateTime modifiedOn, Integer deletedBy, LocalDateTime deletedOn) {
        this.id = id;
        this.employeeProject = employeeProject;
        this.projectTask = projectTask;
        this.description = description;
        this.hoursWorked = hoursWorked;
        this.submittedBy = submittedBy;
        this.submittedOn = submittedOn;
        this.status = status;
        this.approvedBy = approvedBy;
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

    public Integer getEmployeeProject() {
        return this.employeeProject;
    }

    public void setEmployeeProject(Integer employeeProject) {
        this.employeeProject = employeeProject;
    }

    public Integer getProjectTask() {
        return this.projectTask;
    }

    public void setProjectTask(Integer projectTask) {
        this.projectTask = projectTask;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getHoursWorked() {
        return this.hoursWorked;
    }

    public void setHoursWorked(Short hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Integer getSubmittedBy() {
        return this.submittedBy;
    }

    public void setSubmittedBy(Integer submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedOn() {
        return this.submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte byte1) {
        this.status = byte1;
    }

    public Integer getApprovedBy() {
        return this.approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
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
