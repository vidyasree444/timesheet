package com.imaginnovate.Entities;

import java.time.LocalDateTime;

import com.imaginnovate.BaseClass.BaseClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "timesheets")
public class Timesheets extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_project_id", nullable = false)
    public EmployeeProjects employeeProject;

    @ManyToOne
    @JoinColumn(name = "project_task_id", nullable = false)
    public ProjectTasks projectTask;

    @Column(name = "description", length = 100)
    public String description;

    @Column(name = "hours_worked", nullable = false)
    public Short hoursWorked;

    @ManyToOne
    @JoinColumn(name = "submitted_by", nullable = false)
    public Employees submittedBy;

    @Column(name = "submitted_on", nullable = false)
    public LocalDateTime submittedOn;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    public TimesheetStatus status;

    @ManyToOne
    @JoinColumn(name = "approved_by")
    public Employees approvedBy;

    

    public Timesheets() {
    }

    

    public Timesheets(EmployeeProjects employeeProject, ProjectTasks projectTask, String description, Short hoursWorked,
            Employees submittedBy, LocalDateTime submittedOn, TimesheetStatus status, Employees approvedBy) {
        this.employeeProject = employeeProject;
        this.projectTask = projectTask;
        this.description = description;
        this.hoursWorked = hoursWorked;
        this.submittedBy = submittedBy;
        this.submittedOn = submittedOn;
        this.status = status;
        this.approvedBy = approvedBy;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Timesheets [id=" + id + ", employeeProject=" + employeeProject + ", projectTask=" + projectTask
                + ", description=" + description + ", hoursWorked=" + hoursWorked + ", submittedBy=" + submittedBy
                + ", submittedOn=" + submittedOn + ", status=" + status + ", approvedBy=" + approvedBy + "]";
    }

    
}
