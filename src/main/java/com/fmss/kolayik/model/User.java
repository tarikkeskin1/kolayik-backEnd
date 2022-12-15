package com.fmss.kolayik.model;

import com.fmss.kolayik.model.enums.Department;
import com.fmss.kolayik.model.enums.Level;
import com.fmss.kolayik.model.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="surname",nullable = false)
    private String surName;

    @Column(name="e_mail",nullable = false)
    private  String email;

    @Column(name="identity_number",nullable = false)
    private  String identityNumber;

    @Column(name="salary",nullable = false)
    private BigDecimal salary;

    @Column(name="start_date_to_job",nullable = false)
    private LocalDate startDateToJob;

    @Column(name="title",nullable = false)
    private  String title;

    @Column(name="level",nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(name="role",nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name="department",nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    @Column(name="birth_date",nullable = false)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Adress address;

    @OneToMany(mappedBy = "user",fetch =FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Expenses> expenses;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    private List<DayOff> dayOff;







}
