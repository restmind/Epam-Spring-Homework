package com.epam.spring.web.mvc.rentcarservice.api;

import com.epam.spring.web.mvc.rentcarservice.controller.model.UserModel;
import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import com.epam.spring.web.mvc.rentcarservice.validation.BasicInfo;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "User management API")
@RequestMapping("/api/v1/users")
public interface UserApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{email}")
    UserModel getUser(@PathVariable String email);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserModel createUser(@Validated(BasicInfo.class) @RequestBody UserDto userDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{email}")
    UserModel updateUser(@PathVariable String email, @RequestBody UserDto userDto);

    @DeleteMapping(value = "/{email}")
    ResponseEntity<Void> deleteUser(@PathVariable String email);

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "{email}/rent-car")
    UserModel userSetCar(@PathVariable String email, @RequestParam String carNumber);
}
