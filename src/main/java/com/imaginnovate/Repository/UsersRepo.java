package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.UsersDto;
import com.imaginnovate.Entities.Users;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsersRepo implements PanacheRepositoryBase<Users,Integer>{
    
       public List<UsersDto> findAllUsers() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.dto.UsersDto(u.id, u.employee.id, u.username, u.password, u.resetToken, u.resetTokenExpiresAt, u.createdBy, u.createdOn, u.modifiedBy, u.modifiedOn, u.deletedBy, u.deletedOn) FROM Users u",
            UsersDto.class)
            .getResultList();
    }
}
