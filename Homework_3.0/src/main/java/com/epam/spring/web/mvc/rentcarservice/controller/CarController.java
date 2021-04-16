package com.epam.spring.web.mvc.rentcarservice.controller;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CarDto> getCars() {
        return carService.getCars();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{carNumber}")
    public CarDto getCar(@PathVariable String carNumber) {
        return carService.getCar(carNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CarDto createCar(@RequestBody CarDto carDto) {
        return carService.createCar(carDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{carNumber}")
    public CarDto updateCar(@PathVariable String carNumber, @RequestBody CarDto carDto) {
        return carService.updateCar(carNumber, carDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{carNumber}")
    public void deleteCar(@PathVariable String carNumber) {
        carService.deleteCar(carNumber);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/filter/brand={brand}")
    public List<CarDto> findCarsByBrand(@PathVariable String brand) {
        return carService.findByBrand(brand);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/filter/car_class={carClass}")
    public List<CarDto> findCarsByCarClass(@PathVariable String carClass) {
        return carService.findByCarClass(carClass);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sort/price")
    public List<CarDto> sortCarsByRentPrice(@RequestParam String order) {
        return carService.sortByRentPrice(order);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sort/name")
    public List<CarDto> sortCarsByName(@RequestParam String order) {
        return carService.sortByName(order);
    }
}
