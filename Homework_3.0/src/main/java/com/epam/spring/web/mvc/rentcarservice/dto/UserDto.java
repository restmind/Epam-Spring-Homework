package com.epam.spring.web.mvc.rentcarservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
