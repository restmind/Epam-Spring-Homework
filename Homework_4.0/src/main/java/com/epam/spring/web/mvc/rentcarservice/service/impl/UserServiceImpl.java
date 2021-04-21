package com.epam.spring.web.mvc.rentcarservice.service.impl;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.User;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.UserRepository;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import com.epam.spring.web.mvc.rentcarservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarService carService;

    @Override
    public UserDto getUser(String email) {
        log.info("UserService: get user by email {}", email);
        return mapUserToUserDto(userRepository.getUser(email));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        log.info("UserService: create user {}", userDto);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        log.info("UserService: update user with email {}", email);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
        log.info("UserService: delete user with email {}", email);
    }

    @Override
    public UserDto userSetCar(String carNumber, String email) {
        CarDto carDto = carService.getCar(carNumber);
        User user = userRepository.getUser(email);
        user.setCar(carService.getCar(carNumber).isAvailable()?
                carDto : null);
        carDto.setAvailable(false);
        log.info("UserService: set car for user with email {}", email);
        return mapUserToUserDto(user);
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .car(userDto.getCar())
                .build();
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .car(user.getCar())
                .build();
    }
}
