package com.epam.spring.web.mvc.rentcarservice.dto;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private CarDto car;
}
