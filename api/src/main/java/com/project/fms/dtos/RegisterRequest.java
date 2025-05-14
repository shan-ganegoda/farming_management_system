package com.project.fms.dtos;

import com.project.fms.entity.Employee;
import com.project.fms.entity.Role;
import com.project.fms.entity.Userstatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private Employee employee;
    private Userstatus userstatus;
    private Role role;
}
