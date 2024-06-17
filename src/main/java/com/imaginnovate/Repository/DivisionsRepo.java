package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.DivisionsDto;
import com.imaginnovate.Entities.Divisions;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DivisionsRepo implements PanacheRepositoryBase<Divisions,Integer> {

    public List<DivisionsDto> findAllDivisions() {
        return getEntityManager().createQuery(
            "SELECT new com.imaginnovate.Dto.DivisionsDto(d.id, d.name, d.parent.id, d.createdBy, d.created_On, d.modifiedBy, d.modifiedOn, d.deletedBy, d.deletedOn) FROM Divisions d",
            DivisionsDto.class)
            .getResultList();
    }
}
