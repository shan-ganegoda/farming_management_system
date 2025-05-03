package com.project.fms.dtos;

import com.project.fms.entity.Module;
import com.project.fms.entity.Operation;
import com.project.fms.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrivilegeDTO {
    private Integer id;
    private Role role;
    private Module module;
    private Operation operation;
}
