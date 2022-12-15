package com.fmss.kolayik.service.abstracts;

import com.fmss.kolayik.client.dto.request.UpdateUserRequestDto;
import com.fmss.kolayik.client.dto.request.UserRequestDto;
import com.fmss.kolayik.client.dto.response.UserResponseDto;
import com.fmss.kolayik.model.User;

import java.util.List;

public interface UserService {
     List<UserResponseDto> getAllUsers();
     void createUser(UserRequestDto userRequestDto);
     UserResponseDto findUserById(Long userId);
     void deleteUserById(Long userId);


    UpdateUserRequestDto updateUser(Long userId, UpdateUserRequestDto updateUserRequestDto);
}
