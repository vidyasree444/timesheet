package com.imaginnovate.Service;

import java.util.List;
import com.imaginnovate.Dto.DivisionsDto;
import com.imaginnovate.Entities.Divisions;
import com.imaginnovate.Repository.DivisionsRepo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;



@ApplicationScoped
@Transactional
public class DivisionService {
    @Inject
    DivisionsRepo divisionsRepo;

    @Inject
    DivisionService divisionService;

    public List<DivisionsDto> getAllProjections() {
        List<DivisionsDto> results= divisionsRepo.findAllDivisions();
        return results;
    }

    @Transactional
    public DivisionsDto createDivision(DivisionsDto divisionsDto) {
        Divisions division = new Divisions();
        division.name = divisionsDto.getName();
        if (divisionsDto.getParentId() != 0) {
            Divisions divisions = Divisions.findById(divisionsDto.getParentId());
            if (divisions!=null) {
                division.parent = divisions;
            }
            else {
                throw new IllegalArgumentException("Division with ID " + divisionsDto.getParentId() + " not found");
            }
        }
        divisionsRepo.persist(division);
        divisionsDto.setId(division.getId());
        return divisionsDto;
    }
    public DivisionsDto getDivisionById(int id) {
        Divisions division = divisionsRepo.findById(id);
        if (division == null) {
            return null;
        }
        DivisionsDto divisionDto = new DivisionsDto();
        divisionDto.setId(division.getId());
        divisionDto.setName(division.name);
        if (division.parent != null) {
            divisionDto.setParentId(division.parent.getId());
        }
        divisionDto.setCreatedBy(division.createdBy);
        divisionDto.setCreatedOn(division.created_On);
            if (division.deletedBy != null) {
                divisionDto.setDeletedBy(division.deletedBy);
            }
            divisionDto.setDeletedOn(division.deletedOn);
            if (division.modifiedBy != null) {
                divisionDto.setModifiedBy(division.modifiedBy);
            }
            divisionDto.setModifiedOn(division.modifiedOn);
        return divisionDto;
    }
}