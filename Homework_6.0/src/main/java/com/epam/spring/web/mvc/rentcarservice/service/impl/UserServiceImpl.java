package com.epam.spring.web.mvc.rentcarservice.service.impl;

import com.epam.spring.web.mvc.rentcarservice.dto.UserDto;
import com.epam.spring.web.mvc.rentcarservice.exception.CarNotFoundException;
import com.epam.spring.web.mvc.rentcarservice.exception.UserNotFoundException;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.CarRepository;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.UserRepository;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.User;
import com.epam.spring.web.mvc.rentcarservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public UserDto getUser(String email) {
        log.info("UserService: get user by email {}", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        log.info("UserService: create user {}", userDto);
        User user = mapUserDtoToUser(userDto);
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("updating user in database: {}", userDto);
        User user = mapUserDtoToUser(userDto);
        User userFromDB = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(userFromDB);
        user = userRepository.save(user);
        return mapUserToUserDto(user);
    }

    @Override
    public void deleteUser(String email) {
        log.info("deleting user in database by email {}", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    @Override
    public UserDto userSetCar(String carNumber, String email) {
        Car car = carRepository.findByCarNumber(carNumber)
                .orElseThrow(CarNotFoundException::new);
        log.info("UserService: set car for user with email {}", car);
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        log.info("UserService: set car for user with email {}", user);
        if (carRepository.findByCarNumber(carNumber).isPresent()) {
            car.setAvailable(false);
            userRepository.delete(user);
            user.setCar(car);
            userRepository.save(user);
        } else {
            throw new CarNotFoundException();
        }

        log.info("UserService: set car for user with email {}", email);
        return mapUserToUserDto(user);
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phone(userDto.getPhone())
                .houseNumber(userDto.getHouseNumber())
                .zipCode(userDto.getZipCode())
                .city(userDto.getCity())
                .country(userDto.getCountry())
                .car(userDto.getCar())
                .build();
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .houseNumber(user.getHouseNumber())
                .zipCode(user.getZipCode())
                .city(user.getCity())
                .country(user.getCountry())
                .car(user.getCar())
                .build();
    }
}
