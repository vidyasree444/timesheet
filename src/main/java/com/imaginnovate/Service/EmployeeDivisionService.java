package com.imaginnovate.Service;


import java.util.List;

import com.imaginnovate.Dto.EmployeeDivisionsDto;
import com.imaginnovate.Entities.Divisions;
import com.imaginnovate.Entities.EmployeeDivisions;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Repository.EmployeeDivisionsRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeDivisionService {
    @Inject
    EmployeeDivisionsRepo employeeDivisionsRepo;
    public List<EmployeeDivisionsDto> findAllEmployeeDivisions() {
        List<EmployeeDivisionsDto> results = employeeDivisionsRepo.findAllEmployeeDivisions();
        return results;
    }

    @Transactional
    public EmployeeDivisions createEmployeeDivision(EmployeeDivisionsDto employeeDivisionsDto) {
        EmployeeDivisions employeeDivisions = new EmployeeDivisions();
        employeeDivisions.setId(employeeDivisionsDto.getId());

        if (employeeDivisionsDto.getEmployeeId() != 0) {
            Employees employees = Employees.findById(employeeDivisionsDto.getEmployeeId());
            if(employees!=null){
                employeeDivisions.employee=employees;
            }
            else {
                throw new IllegalArgumentException("Employee with ID " + employeeDivisionsDto.getEmployeeId() + " not found");
            }
        }

        if (employeeDivisionsDto.getDivisionId() != 0) {
            Divisions divisions = Divisions.findById(employeeDivisionsDto.getDivisionId());
            if(divisions!=null){
                employeeDivisions.division=divisions;
            }else {
                throw new IllegalArgumentException("Division with ID " + employeeDivisionsDto.getDivisionId() + " not found");
            }
        }

        employeeDivisions.canApproveTimesheets = employeeDivisionsDto.isCanApproveTimesheets();
        employeeDivisionsRepo.persist(employeeDivisions);
        return employeeDivisions;
    }

    public EmployeeDivisionsDto getEmployeeDivisionById(int id) {
        EmployeeDivisions ed = employeeDivisionsRepo.findById(id);
        if (ed == null) {
            return null;
        }
        EmployeeDivisionsDto dto = new EmployeeDivisionsDto();
        dto.setId(ed.getId());
        dto.setEmployeeId(ed.employee.getId());
        dto.setDivisionId(ed.division.getId());
        dto.setCanApproveTimesheets(ed.canApproveTimesheets);
        dto.setCreatedBy(ed.createdBy);
            dto.setCreated_On(ed.created_On);
            if (ed.deletedBy != null) {
                dto.setDeletedBy(ed.deletedBy);
            }
            dto.setDeletedOn(ed.deletedOn);
            if (ed.modifiedBy != null) {
                dto.setModifiedBy(ed.modifiedBy);
            }
            dto.setModifiedOn(ed.modifiedOn);
        return dto;
    }
}
