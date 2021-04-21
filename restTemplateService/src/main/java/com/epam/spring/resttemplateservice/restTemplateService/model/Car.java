package com.epam.spring.resttemplateservice.restTemplateService.model;

import lombok.Data;
import org.springframework.hateoas.Link;

import java.util.List;

@Data
public class Car {
    private String brand;
    private String model;
    private String carClass;
    private String price;
    private String carNumber;
    private boolean available;
    private List<Link> links;

}
