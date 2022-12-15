package com.fmss.kolayik.controller;

import com.fmss.kolayik.client.dto.request.UpdateUserRequestDto;
import com.fmss.kolayik.client.dto.request.UserRequestDto;
import com.fmss.kolayik.client.dto.response.UserResponseDto;
import com.fmss.kolayik.model.User;
import com.fmss.kolayik.service.abstracts.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping()
    public void createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        userService.createUser(userRequestDto);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUserById (@PathVariable Long userId){
       return ResponseEntity.ok(userService.findUserById(userId));
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteUser (@PathVariable Long userId){
        userService.deleteUserById(userId);
    }

    @PutMapping("/{userId}")
    public UpdateUserRequestDto updateUser(@PathVariable Long userId,@RequestBody UpdateUserRequestDto updateUserRequestDto){
        return userService.updateUser(userId,updateUserRequestDto);
    }

}