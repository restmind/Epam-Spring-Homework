package com.epam.spring.web.mvc.rentcarservice.controller;

import com.epam.spring.web.mvc.rentcarservice.api.UserApi;
import com.epam.spring.web.mvc.rentcarservice.controller.assembler.UserAssembler;
import com.epam.spring.web.mvc.rentcarservice.controller.model.UserModel;
import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import com.epam.spring.web.mvc.rentcarservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService userService;
    private final UserAssembler userAssembler;

    @Override
    public UserModel getUser(String email) {
        log.info("Getting user with email{}", email);
        UserDto user = userService.getUser(email);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel createUser(UserDto userDto) {
        log.info("creating user{}", userDto);
        UserDto user = userService.createUser(userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public UserModel updateUser(String email, UserDto userDto) {
        log.info("Updating user with email{}", email);
        UserDto user = userService.updateUser(email, userDto);
        return userAssembler.toModel(user);
    }

    @Override
    public ResponseEntity<Void> deleteUser(String email) {
        log.info("Deleting user with email{}", email);
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

    @Override
    public UserModel userSetCar(String email, String carNumber) {
        log.info("Setting car for user with email{}", email);
        UserDto user = userService.userSetCar(carNumber, email);
        return userAssembler.toModel(user);
    }
}
