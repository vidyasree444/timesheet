package com.imaginnovate.Service;

import java.util.ArrayList;
import java.util.List;

import com.imaginnovate.Dto.UsersDto;
import com.imaginnovate.Entities.Employees;
import com.imaginnovate.Entities.Users;
import com.imaginnovate.Repository.UsersRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {
    @Inject
    UsersRepo usersRepo;
    public List<UsersDto> getAllUsers() {
        List<Users> users = Users.listAll();
        List<UsersDto> usersDtos = new ArrayList<>();
        for (Users u : users) {
            UsersDto dto = new UsersDto();
            dto.setId(u.getId());
            dto.setUsername(u.username);
            dto.setPassword(u.password);
            dto.setEmployeeId(u.employeeId.getId());
            dto.setResetToken(u.resetToken);
            dto.setResetTokenExpiresAt(u.resetTokenExpiresAt);
            dto.setCreatedBy(u.createdBy);
            dto.setCreated_On(u.created_On);
            if (u.deletedBy != null) {
                dto.setDeletedBy(u.deletedBy);
            }
            dto.setDeletedOn(u.deletedOn);
            if (u.modifiedBy != null) {
                dto.setModifiedBy(u.modifiedBy);
            }
            dto.setModifiedOn(u.modifiedOn);
            usersDtos.add(dto);
        }
        return usersDtos;
    }
    @Transactional
    public Users addUser(UsersDto usersDto) {
        Users users = new Users();
        users.setId(usersDto.getId());
        users.username = usersDto.getUsername();
        users.password = usersDto.getPassword();
        users.resetToken = usersDto.getResetToken();
        users.resetTokenExpiresAt = usersDto.getResetTokenExpiresAt();
        if (usersDto.getEmployeeId() != 0) {
            Employees employee = Employees.findById(usersDto.getEmployeeId());
            if (employee !=null) {
                users.employeeId = employee;
            } else {
                throw new IllegalArgumentException("Employee with ID " + usersDto.getEmployeeId() + " not found");
            }
        }
        users.persist();
        return users;
    }


    public UsersDto getUserById(int id) {
        Users users = usersRepo.findById(id);
        if (users == null) {
            return null;
        }
        UsersDto dto = new UsersDto();
        dto.setId(users.getId());
        dto.setUsername(users.username);
        dto.setPassword(users.password);
        dto.setEmployeeId(users.employeeId.getId());
        dto.setResetToken(users.resetToken);
        dto.setResetTokenExpiresAt(users.resetTokenExpiresAt);
        dto.setCreatedBy(users.createdBy);
        dto.setCreated_On(users.created_On);
        if (users.deletedBy != null) {
            dto.setDeletedBy(users.deletedBy);
        }
        dto.setDeletedOn(users.deletedOn);
        if (users.modifiedBy != null) {
            dto.setModifiedBy(users.modifiedBy);
        }
        dto.setModifiedOn(users.modifiedOn);
        return dto;
    }
    
}