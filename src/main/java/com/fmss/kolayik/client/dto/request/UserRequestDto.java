package com.fmss.kolayik.client.dto.request;
import com.fmss.kolayik.model.enums.Department;
import com.fmss.kolayik.model.enums.Level;
import com.fmss.kolayik.model.enums.Role;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestDto {


    @NotBlank(message = "Name cannot empty")
    private String name;

    @NotBlank(message = "SurName cannot empty")
    private String surName;

    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: tarik@mail.com")
    @NotBlank(message = "Email must not be null")
    private  String email;
    @Pattern(regexp="^[1-9]{1}[0-9]{9}[02468]{1}$",message = "Tc Uygun formatta Değil!")
    private  String identityNumber;

    @NotBlank(message = "İşe başlama tarihi alanı boş geçilemez")
    private LocalDate startDateToJob;

    @NotBlank(message = "Ünvan alanı boş olamaz")
    private  String title;

    @NotBlank(message = "Seviye alanı boş olamaz")
    private Level level;

    private Role role;
    @NotBlank(message = "Rol boş alanı olamaz")
    private Department department;

    @NotBlank(message = "Doğum tarihi alanı boş olamaz")
    private LocalDate birthDate;

    @NotBlank(message = "Maaş alanı boş olamaz")
    private BigDecimal salary;
    //Adress

    @NotBlank(message = "Adres alanı Boş olamaz")
    private String address;

    @NotBlank(message = "Ülke alanı boş olamaz")
    private String country;


    @NotBlank(message = "Şehir alanı boş olamaz")
    private String city;

    @NotBlank(message = "Posta kodu alanı boş olamaz")
    private String postCode;
    
    @Pattern(regexp="/^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$/\n",message = "Telefon numarası uygun formatta Değil!")
    @NotBlank(message = "Telefon numarası alanı boş olamaz")
    private String phoneNumber;
}
