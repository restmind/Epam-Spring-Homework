package com.epam.spring.web.mvc.rentcarservice.service.impl;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.User;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.UserRepository;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import com.epam.spring.web.mvc.rentcarservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarService carService;

    @Override
    public UserDto getUser(String email) {
        return mapUserToUserDto(userRepository.getUser(email));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }

    @Override
    public UserDto userSetCar(String carNumber, String email) {
        CarDto carDto = carService.getCar(carNumber);
        User user = userRepository.getUser(email);
        user.setCar(carService.getCar(carNumber).isAvailable()?
                carDto : null);
        carDto.setAvailable(false);
        return mapUserToUserDto(user);
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .password(userDto.getPassword())
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
