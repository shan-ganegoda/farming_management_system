package com.project.fms.repository;

import com.project.fms.entity.Module;
import com.project.fms.entity.Operation;
import com.project.fms.entity.Privilege;
import com.project.fms.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

    boolean existsByRoleAndModuleAndOperation(Role role, Module module, Operation operation);
}
