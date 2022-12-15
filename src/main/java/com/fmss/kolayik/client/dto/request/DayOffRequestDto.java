package com.fmss.kolayik.client.dto.request;
import com.fmss.kolayik.model.enums.DayOffType;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayOffRequestDto {



    @NotNull(message = "User id must not be null")
    private Long userId;

    private int totalDay;

    @NotBlank(message = "İzin türü alanı boş bırakılamaz")
    private DayOffType dayOffType;

    @NotBlank(message = "İzin başlangıç tarihi alanı boş bırakılamaz")
    private LocalDate startDate;

    @NotBlank(message = "İzin bitiş taihi alanı boş bırakılamaz")
    private LocalDate finishDate;

    @NotBlank(message = "İzin açıklaması alanı boş bırakılamaz")
    private String dayOffComment;

}
