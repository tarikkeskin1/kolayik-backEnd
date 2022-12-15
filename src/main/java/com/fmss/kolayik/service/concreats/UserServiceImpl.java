package com.fmss.kolayik.service.concreats;

import com.fmss.kolayik.client.dto.request.UpdateUserRequestDto;
import com.fmss.kolayik.client.dto.request.UserRequestDto;
import com.fmss.kolayik.client.dto.response.UserResponseDto;
import com.fmss.kolayik.exceptions.UserNotFoundException;
import com.fmss.kolayik.mapper.UserMapper;
import com.fmss.kolayik.model.User;
import com.fmss.kolayik.repository.UserRepository;
import com.fmss.kolayik.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;




    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAllUsers();       //Map işlemi repository de projection ile yapıldı.

    }

    @Override
    public void createUser(UserRequestDto userRequestDto) {
        userRepository.save(userMapper.toUserFromUserRequestDto(userRequestDto));
    }

    @Override
    public UserResponseDto findUserById(Long userId) {
        return userRepository.findUserById(userId);  //Map işlemi repository de projection ile yapıldı.
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UpdateUserRequestDto updateUser(Long userId, UpdateUserRequestDto updateUserRequestDto) {
        userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(" Kullanıcı bulunamadı"));

        userRepository.updateUser(updateUserRequestDto.getEmail(),
               updateUserRequestDto.getDepartment(),
               updateUserRequestDto.getSalary(),
               userId);
        return updateUserRequestDto ;
    }
}
