package com.fmss.kolayik.client.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayOffResponseDto {

    private Long userId;
    private Long dayOffId;

    private  String userName;
    private  String surName;
    private int totalDay;

    private LocalDate startDate;

    private LocalDate finishDate;

    private String dayOffComment;







}
