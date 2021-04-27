package com.epam.spring.web.mvc.rentcarservice.controller;

import com.epam.spring.web.mvc.rentcarservice.api.CarApi;
import com.epam.spring.web.mvc.rentcarservice.controller.assembler.CarAssembler;
import com.epam.spring.web.mvc.rentcarservice.controller.model.CarModel;
import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {
    private final CarService carService;
    private final CarAssembler carAssembler;

    @Override
    public List<CarModel> getAvailableCars() {
        log.info("Getting list of car");
        List<CarDto> carDtoList = carService.getAvailableCars();

        return carDtoList.stream().map(carAssembler::toModel).collect(Collectors.toList());
    }

    @Override
    public CarModel getCar(String carNumber) {
        log.info("Getting car with carNumber{}", carNumber);
        CarDto carDto = carService.getCar(carNumber);
        return carAssembler.toModel(carDto);
    }

    @Override
    public CarModel createCar(CarDto carDto) {
        log.info("Creating CarDto{}", carDto);
        CarDto car = carService.createCar(carDto);
        return carAssembler.toModel(car);
    }

    @Override
    public CarModel updateCar(String carNumber, CarDto carDto) {
        log.info("Updating car with carNumber{}", carNumber);
        CarDto car = carService.updateCar(carNumber, carDto);
        return carAssembler.toModel(car);
    }


    @Override
    public ResponseEntity<Void> deleteCar(String carNumber) {
        carService.deleteCar(carNumber);
        log.info("Deleting car with carNumber{}", carNumber);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<CarModel> findCarsByBrand(String brand, int page, int size) {
        log.info("Finding car by brand{}", brand);
        List<CarDto> carDtoList = carService.findAllByBrand(brand, page, size);
        return carDtoList.stream().map(carAssembler::toModel).collect(Collectors.toList());
    }

    @Override
    public List<CarModel> findCarsByCarClass(String carClass, int page, int size) {
        log.info("Finding car by carClass{}", carClass);
        List<CarDto> carDtoList = carService.findAllByCarClass(carClass, page, size);
        return carDtoList.stream().map(carAssembler::toModel).collect(Collectors.toList());

    }

    @Override
    public List<CarModel> sortCarsByPrice(int page, int size) {
        log.info("Sorting cars by price with order{}");

        List<CarDto> carDtoList = carService.sortByPrice(page, size);

        return carDtoList.stream().map(carAssembler::toModel).collect(Collectors.toList());
    }

    @Override
    public List<CarModel> sortCarsByName() {
        log.info("Sorting cars by name with order{}");
        List<CarDto> carDtoList = carService.sortByName();
        return carDtoList.stream().map(carAssembler::toModel).collect(Collectors.toList());
    }
}
