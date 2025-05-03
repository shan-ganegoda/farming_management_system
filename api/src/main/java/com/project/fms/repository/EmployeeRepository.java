package com.project.fms.repository;

import com.project.fms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    boolean existsByNic(String nic);
    boolean existsByEmail(String email);
    boolean existsByMobile(String mobile);
    boolean existsByLand(String land);
    boolean existsByEmpnumber(String empnumber);
}
