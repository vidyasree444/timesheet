package com.imaginnovate.Entities;

import com.imaginnovate.BaseClass.BaseClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "employee_divisions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"employee_id", "project_id"})
})
public class EmployeeDivisions extends BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    public Employees employee;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    public Divisions division;

    @Column(name = "can_approve_timesheets", nullable = false)
    public boolean canApproveTimesheets;


    public EmployeeDivisions() {
    }

    public EmployeeDivisions(int id, Employees employee, Divisions division, boolean canApproveTimesheets) {
        this.id = id;
        this.employee = employee;
        this.division = division;
        this.canApproveTimesheets = canApproveTimesheets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeDivisions [id=" + id + ", employee=" + employee + ", division=" + division
                + ", canApproveTimesheets=" + canApproveTimesheets + "]";
    }
}
