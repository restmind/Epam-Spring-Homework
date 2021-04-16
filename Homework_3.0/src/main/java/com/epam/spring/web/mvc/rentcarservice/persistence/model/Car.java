package com.epam.spring.web.mvc.rentcarservice.persistence.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String brand;
    private String model;
    private String carClass;
    private int price;
    private String carNumber;
    private boolean isAvailable = true;
}
