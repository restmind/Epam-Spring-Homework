package com.epam.spring.web.mvc.rentcarservice.controller;

import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import com.epam.spring.web.mvc.rentcarservice.service.UserService;
import com.epam.spring.web.mvc.rentcarservice.validation.BasicInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    public UserDto getUser(@PathVariable String email) {
        log.info("Getting user with email{}", email);
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@Validated(BasicInfo.class)  @RequestBody UserDto userDto) {
        log.info("creating user{}", userDto);
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto) {
        log.info("Updating user with email{}", email);
        return userService.updateUser(email, userDto);
    }

    @DeleteMapping(value = "/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        log.info("Deleting user with email{}", email);
        userService.deleteUser(email);
        return  ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "{email}/rent-car")
    public UserDto UserSetCar(@PathVariable String email, @RequestParam String carNumber) {
        log.info("Setting car for user with email{}", email);
        return userService.userSetCar(carNumber, email);

    }
}
