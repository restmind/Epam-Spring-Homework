package com.epam.spring.web.mvc.rentcarservice.dto;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.validation.AdvancedInfo;
import com.epam.spring.web.mvc.rentcarservice.validation.BasicInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    @Size(max = 45, groups = BasicInfo.class)
    private String firstName;
    @Size(max = 45, groups = BasicInfo.class)
    private String lastName;
    @Email(groups = BasicInfo.class)
    private String email;

    @Pattern(regexp = "\\d{12}", groups = BasicInfo.class)
    private String phone;

    @Length(min = 8, max = 45, groups = BasicInfo.class)
    private String password;

    @NotBlank(groups = AdvancedInfo.class)
    private String street;

    @NotBlank(groups = AdvancedInfo.class)
    private String houseNumber;

    @NotBlank(groups = AdvancedInfo.class)
    private String zipCode;

    @NotBlank(groups = AdvancedInfo.class)
    private String city;

    @NotBlank(groups = AdvancedInfo.class)
    private String country;

    private Car car;
}
