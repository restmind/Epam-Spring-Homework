package com.epam.spring.web.mvc.rentcarservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDto {
    private Long id;
    @NotNull
    @Size(max = 45)
    private String brand;
    @NotNull
    @Size(max = 45)
    private String model;
    @NotNull
    @Pattern(regexp = "[A-F]")
    private String carClass;
    @NotNull
    private int price;
    @NotNull
    @Pattern(regexp = "[A-Z]{2}\\d{4}[A-Z]{2}")
    private String carNumber;
    private boolean isAvailable;
}
