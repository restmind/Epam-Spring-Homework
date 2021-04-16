package com.epam.spring.web.mvc.rentcarservice.controller;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CarDto> getCars() {
        log.info("Getting list of car");
        return carService.getCars();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{carNumber}")
    public CarDto getCar(@PathVariable String carNumber) {
        log.info("Getting car with carNumber{}", carNumber);
        return carService.getCar(carNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CarDto createCar(@Valid @RequestBody CarDto carDto) {
        log.info("Creating CarDto{}", carDto);
        return carService.createCar(carDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{carNumber}")
    public CarDto updateCar(@PathVariable String carNumber, @RequestBody CarDto carDto) {
        log.info("Updating car with carNumber{}", carNumber);
        return carService.updateCar(carNumber, carDto);
    }


    @DeleteMapping(value = "/{carNumber}")
    public ResponseEntity<Void> deleteCar(@PathVariable String carNumber) {
        carService.deleteCar(carNumber);
        log.info("Deleting car with carNumber{}", carNumber);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/filter/brand={brand}")
    public List<CarDto> findCarsByBrand(@PathVariable String brand) {
        log.info("Finding car by brand{}", brand);
        return carService.findByBrand(brand);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/filter/car_class={carClass}")
    public List<CarDto> findCarsByCarClass(@PathVariable String carClass) {
        log.info("Finding car by carClass{}", carClass);
        return carService.findByCarClass(carClass);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sort/price")
    public List<CarDto> sortCarsByRentPrice(@RequestParam String order) {
        log.info("Sorting cars by price with order{}", order);
        return carService.sortByRentPrice(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sort/name")
    public List<CarDto> sortCarsByName(@RequestParam String order) {
        log.info("Sorting cars by name with order{}", order);
        return carService.sortByName(order);
    }
}
