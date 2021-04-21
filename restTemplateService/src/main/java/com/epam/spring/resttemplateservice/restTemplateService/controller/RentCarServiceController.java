package com.epam.spring.resttemplateservice.restTemplateService.controller;

import com.epam.spring.resttemplateservice.restTemplateService.model.Car;
import com.epam.spring.resttemplateservice.restTemplateService.service.RentCarServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-template/cars")
@RequiredArgsConstructor
public class RentCarServiceController {
    private final RentCarServiceService rentCarServiceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{carNumber}")
    public Car getCar(@PathVariable String carNumber) {
        return rentCarServiceService.getCar(carNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return rentCarServiceService.createCar(car);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{carNumber}")
    public void updateCar(@PathVariable String carNumber, @RequestBody Car car) {
        rentCarServiceService.updateCar(carNumber, car);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{carNumber}")
    public void deleteCar(@PathVariable String carNumber) {
        rentCarServiceService.deleteCar(carNumber);
    }

}
