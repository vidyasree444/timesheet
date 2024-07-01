package com.imaginnovate.Service;

import java.util.List;
import java.util.Optional;

import com.imaginnovate.Dto.EmployeeDto;
import com.imaginnovate.Entities.Divisions;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Repository.DivisionsRepo;
import com.imaginnovate.Repository.EmployeesRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmployeeService {
    @Inject
    EmployeesRepo employeesRepository;

    @Inject
    DivisionsRepo divisionsRepo;

    
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> results =  employeesRepository.findAllProjections();
        return results;
    }

    @Transactional
    public Employees addEmployee(EmployeeDto employeeDto) {
        Employees employees = new Employees();
        employees.setId(employeeDto.getId());
        employees.firstName = employeeDto.getFirstName();
        employees.lastName = employeeDto.getLastName();
        employees.email = employeeDto.getEmail();
        employees.gender = employeeDto.getGender();
        employees.designation = employeeDto.getDesignation();
        employees.startDate = employeeDto.getStartDate();
        employees.endDate = employeeDto.getEndDate();

        if (employeeDto.getDivisionId() != 0) {
            Divisions division = Divisions.findById(employeeDto.getDivisionId());
            if (division != null) {
                employees.division = division;
            } else {
                throw new IllegalArgumentException("Division with ID " + employeeDto.getDivisionId() + " not found");
            }
        }

        if (employeeDto.getReportsToId() != 0) {
            Optional<Employees> reportsToOptional = Employees.findByIdOptional(employeeDto.getReportsToId());
            if (reportsToOptional.isPresent()) {
                employees.reports_to = reportsToOptional.get();
            } else {
                throw new IllegalArgumentException("Employee with ID " + employeeDto.getReportsToId() + " not found");
            }
        }

        employees.persist();
        return employees;
    }

    
    public EmployeeDto getEmployeeById(int id) {
        Employees employees = employeesRepository.findById(id);
        if (employees == null) {
            return null;
        }
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employees.getId()); 
        dto.setFirstName(employees.firstName);
        dto.setLastName(employees.lastName);
        dto.setGender(employees.gender);
        dto.setEmail(employees.email);
        dto.setDesignation(employees.designation);
        dto.setStartDate(employees.startDate);
        dto.setEndDate(employees.endDate);
        dto.setDivisionId(employees.division.getId());
        if (employees.reports_to != null) {
            dto.setReportsToId(employees.reports_to.getId());
        }
        dto.setCreatedBy(employees.createdBy);
        dto.setCreated_On(employees.created_On);
        if (employees.deletedBy != null) {
            dto.setDeletedBy(employees.deletedBy);
        }
        dto.setDeletedOn(employees.deletedOn);
        if (employees.modifiedBy != null) {
            dto.setModifiedBy(employees.modifiedBy);
        }
        dto.setModifiedOn(employees.modifiedOn);
        return dto;
    }

}




