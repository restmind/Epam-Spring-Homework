package com.epam.spring.web.mvc.rentcarservice.service.impl;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.CarRepository;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getCars() {
        return carRepository.getCars().stream().map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public CarDto getCar(String carNumber) {
        return mapCarToCarDto(carRepository.getCar(carNumber));
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.createCar(car);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto updateCar(String carNumber, CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.updateCar(carNumber, car);
        return mapCarToCarDto(car);
    }

    @Override
    public void deleteCar(String carNumber) {
        carRepository.deleteCar(carNumber);
    }

    @Override
    public List<CarDto> findByBrand(String brand) {
        return carRepository.findByBrand(brand).stream().map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> findByCarClass(String carClass) {
        return carRepository.findByCarClass(carClass).stream().map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> sortByRentPrice(String order) {
        return carRepository
                .getCars()
                .stream()
                .sorted(order.equals("DESC")? Comparator.comparingInt(Car::getPrice).reversed()
                        : Comparator.comparingInt(Car::getPrice))
                .map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> sortByName(String order) {
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
                .price(car.getPrice())
                .isAvailable(car.isAvailable())
                .build();
    }
}
