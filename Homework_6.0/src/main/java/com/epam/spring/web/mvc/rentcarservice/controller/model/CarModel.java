package com.epam.spring.web.mvc.rentcarservice.controller.model;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;


@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CarModel extends RepresentationModel<CarModel> {
    @JsonUnwrapped
    private CarDto carDto;
}
