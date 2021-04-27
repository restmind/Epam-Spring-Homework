package com.epam.spring.web.mvc.rentcarservice.service;

import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    UserDto getUser(String email);

    @Transactional
    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);

    void deleteUser(String email);

    @Transactional
    UserDto userSetCar(String carNumber, String email);
}
