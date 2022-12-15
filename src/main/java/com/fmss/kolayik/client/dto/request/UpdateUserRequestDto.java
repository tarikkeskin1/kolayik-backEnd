package com.fmss.kolayik.client.dto.request;

import com.fmss.kolayik.model.enums.Department;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUserRequestDto {
    @Email(regexp = "^(.+)@(.+)$", message = "Email geçerli değil lütfen bu örnekteki formatta yazalım: tarikfmss@gmail.com")
    @NotBlank(message = "Email boş bırakılamaz")
    private String email;
    @NotNull
    @Min(value = 0, message = "Maaş 0 dan küçük olamaz.")
    private BigDecimal salary;
    @NotBlank(message = "Departman boş bırakılamaz")
    private Department department;

}
