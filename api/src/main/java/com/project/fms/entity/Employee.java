package com.project.fms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "nic", length = 12)
    private String nic;

    @Column(name = "empnumber", length = 45)
    private String empnumber;

    @Column(name = "mobile", length = 10)
    private String mobile;

    @Column(name = "land", length = 10)
    private String land;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @Column(name = "dob")
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @Column(name = "doassigned")
    private LocalDate doassigned;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employeestatus_id", nullable = false)
    private Employeestatus employeestatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "employeetype_id", nullable = false)
    private Employeetype employeetype;

    @Lob
    @Column(name = "description")
    private String description;

}