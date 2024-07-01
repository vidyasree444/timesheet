package com.imaginnovate.Dto;

import java.time.LocalDateTime;

public class EmployeeDivisionsDto {
    private Integer id;

    private Integer employeeId;

    private Integer divisionId;

    private boolean canApproveTimesheets;

    private Integer createdBy;

    private LocalDateTime created_On;

    private Integer modifiedBy;

    private LocalDateTime modifiedOn;

    private Integer deletedBy;
    
    private LocalDateTime deletedOn;
    

    public EmployeeDivisionsDto() {
    }



    public EmployeeDivisionsDto(Integer id, Integer employeeId, Integer divisionId, boolean canApproveTimesheets, Integer createdBy, LocalDateTime created_On, Integer modifiedBy, LocalDateTime modifiedOn, Integer deletedBy, LocalDateTime deletedOn) {
        this.id = id;
        this.employeeId = employeeId;
        this.divisionId = divisionId;
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

    public Integer getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getDivisionId() {
        return this.divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public boolean isCanApproveTimesheets() {
        return this.canApproveTimesheets;
    }

    public boolean getCanApproveTimesheets() {
        return this.canApproveTimesheets;
    }

    public void setCanApproveTimesheets(boolean canApproveTimesheets) {
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

}
    
    