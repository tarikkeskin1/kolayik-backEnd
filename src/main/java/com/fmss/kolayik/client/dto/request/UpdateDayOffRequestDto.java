package com.fmss.kolayik.client.dto.request;

import com.fmss.kolayik.model.enums.DayOffType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDayOffRequestDto {

    @NotBlank(message = "İzin türü alanı boş bırakılamaz")
    private String dayOffComment;

    @NotBlank(message = "İzin başlangıç tarihi alanı boş bırakılamaz")
    private LocalDate startDate;

    @NotBlank(message = "İzin bitiş tarihi alanı boş bırakılamaz")
    private LocalDate finishDate;

    @NotBlank(message = "İzin türü alanı boş bırakılamaz")
    private DayOffType dayOffType;



}
