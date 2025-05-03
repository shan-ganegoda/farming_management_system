package com.project.fms.dtos;

import com.project.fms.entity.Employee;
import com.project.fms.entity.Role;
import com.project.fms.entity.Userstatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private Employee employee;
    private String username;
    private String password;
    private String description;
    private LocalDate docreated;
    private LocalDate dolastupdated;
    private Userstatus userstatus;
    private Role role;
}
