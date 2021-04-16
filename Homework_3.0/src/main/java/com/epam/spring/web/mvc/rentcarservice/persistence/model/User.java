package com.epam.spring.web.mvc.rentcarservice.persistence.model;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    private CarDto car;
}
