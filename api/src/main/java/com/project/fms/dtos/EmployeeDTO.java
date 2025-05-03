package com.project.fms.dtos;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.project.fms.entity.Designation;
import com.project.fms.entity.Employeestatus;
import com.project.fms.entity.Employeetype;
import com.project.fms.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private byte[] photo;
    private String nic;
    private String empnumber;
    private String mobile;
    private String land;
    private String email;
    private Gender gender;
    private LocalDate dob;
    private Designation designation;
    private LocalDate doassigned;
    private Employeestatus employeestatus;
    private Employeetype employeetype;
    private String description;
}
