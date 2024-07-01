package com.imaginnovate.Repository;

import java.util.List;

import com.imaginnovate.Dto.TimesheetDto;
import com.imaginnovate.Entities.Timesheets;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TimesheetRepo implements PanacheRepositoryBase<Timesheets,Integer> {
        public List<TimesheetDto> findAllTimesheets() {
                return getEntityManager().createQuery(
                        "SELECT new com.imaginnovate.Dto.TimesheetDto(t.id, t.employeeProject.id, t.projectTask.id, t.description, t.hoursWorked, t.submittedBy.id, t.submittedOn, t.status.id, t.approvedBy.id, t.createdBy, t.created_On, t.modifiedBy, t.modifiedOn, t.deletedBy, t.deletedOn) FROM Timesheets t",
                        TimesheetDto.class).getResultList();
}

public void updateTimesheetStatusForDivision(int divisionId, int approverId) {
        String jpql = "UPDATE Timesheets t SET t.status.id = (SELECT id FROM TimesheetStatus WHERE name = 'approved'), t.approvedBy.id = :approverId " + "WHERE t.status.id = (SELECT id FROM TimesheetStatus WHERE name = 'pending') AND t.employeeProject.employee.id IN " +"(SELECT e.id FROM Employees e WHERE e.divisionId = :divisionId OR e.division.parentId = :divisionId)";
        getEntityManager().createQuery(jpql)
                .setParameter("approverId", approverId)
                .setParameter("divisionId", divisionId)
                .executeUpdate();
}

public void updateTimesheetStatusForProject(int projectId, int approverId) {
        String jpql = "UPDATE Timesheets t " +
                      "SET t.status.id = (SELECT id FROM TimesheetStatus WHERE name = 'approved'), " +
                      "t.approvedBy.id = :approverId " +
                      "WHERE t.status.id = (SELECT id FROM TimesheetStatus WHERE name = 'pending') " +
                      "AND t.employeeProject.project.id = :projectId " +
                      "AND t.employeeProject.canApproveTimesheets = FALSE";
        getEntityManager().createQuery(jpql)
                .setParameter("approverId", approverId)
                .setParameter("projectId", projectId)
                .executeUpdate();
    }

@Transactional
public void updateTimesheetStatusForManager(int projectId, int managerId, int approverId) {
        String jpql = "UPDATE Timesheets t SET t.status.id = (SELECT id FROM TimesheetStatus WHERE name = 'approved'), t.approvedBy.id = :approverId " +
                "WHERE t.status.id = (SELECT id FROM TimesheetStatus WHERE name = 'pending') AND t.employeeProject.projectId = :projectId " +
                "AND t.employeeProject.employee.reportsTo = :managerId";
        getEntityManager().createQuery(jpql)
                .setParameter("approverId", approverId)
                .setParameter("projectId", projectId)
                .setParameter("managerId", managerId)
                .executeUpdate();
}


}