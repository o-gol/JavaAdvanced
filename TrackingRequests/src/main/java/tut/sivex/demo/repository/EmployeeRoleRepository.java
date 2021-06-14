package tut.sivex.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tut.sivex.demo.entity.EmployeeRole;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Void>, JpaSpecificationExecutor<EmployeeRole> {

}