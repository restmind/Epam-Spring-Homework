package com.epam.spring.web.mvc.rentcarservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {
    private String brand;
    private String model;
    private String carClass;
    private int price;
    private String carNumber;
    private boolean isAvailable;
}
