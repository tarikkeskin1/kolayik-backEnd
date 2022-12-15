package com.fmss.kolayik.client.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fmss.kolayik.model.enums.Department;
import com.fmss.kolayik.model.enums.Level;
import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private Long userId;
    private String name;

    private String surName;

    private  String email;
    private LocalDate startDateToJob;

    private  String title;

    private Level level;

    private Department department;
    //Adress

    private String address;

    private String country;

    private String city;

    private String phoneNumber;

}
