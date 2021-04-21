package com.epam.spring.web.mvc.rentcarservice.service.impl;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.CarRepository;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getCars() {
        log.info("CarService: get list of cars");
        return carRepository.getCars().stream().map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public CarDto getCar(String carNumber) {
        log.info("CarService: get car by carNumber {}", carNumber);
        return mapCarToCarDto(carRepository.getCar(carNumber));
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.createCar(car);
        log.info("CarService: create car {}", carDto);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto updateCar(String carNumber, CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.updateCar(carNumber, car);
        log.info("CarService: update car with carNumber {}", carNumber);
        return mapCarToCarDto(car);
    }

    @Override
    public void deleteCar(String carNumber) {
        carRepository.deleteCar(carNumber);
        log.info("CarService: delete car with carNumber {}", carNumber);
    }

    @Override
    public List<CarDto> findByBrand(String brand) {
        log.info("CarService: find cars by brand {}", brand);
        return carRepository.findByBrand(brand).stream().map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> findByCarClass(String carClass) {
        log.info("CarService: find cars by carClass {}", carClass);
        return carRepository.findByCarClass(carClass).stream().map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> sortByRentPrice(String order) {
        log.info("CarService: sort cars by price with order {}", order);
        return carRepository
                .getCars()
                .stream()
                .sorted(order.equals("DESC")? Comparator.comparing(Car::getPrice).reversed()
                        : Comparator.comparing(Car::getPrice))
                .map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> sortByName(String order) {
        log.info("CarService: sort cars by name with order {}", order);
        return carRepository
                .getCars()
                .stream()
                .sorted(order.equals("DESC")? Comparator.comparing(Car::getBrand).thenComparing(Car::getModel).reversed()
                        : Comparator.comparing(Car::getBrand).thenComparing(Car::getModel))
                .map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    private Car mapCarDtoToCar(CarDto carDto) {
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .carClass(carDto.getCarClass())
                .price(carDto.getPrice())
                .carNumber(carDto.getCarNumber())
                .isAvailable(carDto.isAvailable())
                .build();
    }

    private CarDto mapCarToCarDto(Car car) {
        return CarDto.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .carClass(car.getCarClass())
                .carNumber(car.getCarNumber())
                .price(car.getPrice())
                .isAvailable(car.isAvailable())
                .build();
    }
}
