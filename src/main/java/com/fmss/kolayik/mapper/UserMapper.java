package com.fmss.kolayik.mapper;

import com.fmss.kolayik.client.dto.request.UserRequestDto;
import com.fmss.kolayik.client.dto.response.UserResponseDto;
import com.fmss.kolayik.model.Adress;
import com.fmss.kolayik.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserResponseDto toUserDto(User user,Adress adress){
        UserResponseDto userResponseDto=new UserResponseDto();

      return UserResponseDto.builder()
              .userId(user.getUserId())
              .name(user.getName())
              .surName(user.getSurName())
              .email(user.getEmail())
              .startDateToJob(user.getStartDateToJob())
              .title(user.getTitle())
              .level(user.getLevel())
              .department(user.getDepartment())
              .address(adress.getAdress())
              .country(adress.getCountry())
              .city(adress.getCity())
              .phoneNumber(adress.getPhoneNumber())
              .build();


    }

    public User toUserFromUserRequestDto(UserRequestDto userRequestDto){
        User user = new User();
        Adress adress = new Adress();
        user.setName(userRequestDto.getName());
        user.setIdentityNumber(userRequestDto.getIdentityNumber());
        user.setSurName(userRequestDto.getSurName());
        user.setEmail(userRequestDto.getEmail());
        user.setLevel(userRequestDto.getLevel());
        user.setDepartment(userRequestDto.getDepartment());
        user.setRole(userRequestDto.getRole());
        user.setSalary(userRequestDto.getSalary());
        user.setTitle(userRequestDto.getTitle());
        user.setBirthDate(userRequestDto.getBirthDate());
        user.setStartDateToJob(userRequestDto.getStartDateToJob());
        adress.setAdress(userRequestDto.getAddress());
        adress.setCity(userRequestDto.getCity());
        adress.setCountry(userRequestDto.getCountry());
        adress.setPhoneNumber(userRequestDto.getPhoneNumber());
        adress.setPostCode(userRequestDto.getPostCode());
        adress.setUser(user);
        user.setAddress(adress);
        return user;
    }
//Adress.builder().adress(userRequestDto.getAddress())
//            .country(userRequestDto.getCountry())
//            .city(userRequestDto.getCity())
//            .postCode(userRequestDto.getPostCode())
//            .phoneNumber(userRequestDto.getPhoneNumber())
//            .user(User.builder().build())
//            .build();
//        return User.builder().name(userRequestDto.getName())
//            .surName(userRequestDto.getSurName())
//            .eMail(userRequestDto.getEMail())
//            .identityNumber(userRequestDto.getIdentityNumber())
//            .startDateToJob(userRequestDto.getStartDateToJob())
//            .title(userRequestDto.getTitle())
//            .level(userRequestDto.getLevel())
//            .role(userRequestDto.getRole())
//            .department(userRequestDto.getDepartment())
//            .salary(userRequestDto.getSalary())
//            .adress(Adress.builder().build())
//            .build();



}
