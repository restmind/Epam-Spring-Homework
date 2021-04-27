package com.epam.spring.web.mvc.rentcarservice.service.impl;

import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import com.epam.spring.web.mvc.rentcarservice.exception.CarNotFoundException;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.CarRepository;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<CarDto> getAvailableCars() {
        log.info("CarService: get list of cars");
        return carRepository.findAllByIsAvailable()
                .stream()
                .map(this::mapCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto getCar(String carNumber) {
        log.info("CarService: get car by carNumber {}", carNumber);
        Car car = carRepository.findByCarNumber(carNumber)
                .orElseThrow(CarNotFoundException::new);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        car = carRepository.save(car);
        log.info("CarService: create car {}", carDto);
        return mapCarToCarDto(car);
    }

    @Override
    public CarDto updateCar(String carNumber, CarDto carDto) {
        Car car = mapCarDtoToCar(carDto);
        Car carFromDB = carRepository.findByCarNumber(carNumber)
                .orElseThrow(CarNotFoundException::new);
        carRepository.delete(carFromDB);
        car = carRepository.save(car);
        log.info("CarService: update car with carNumber {}", carNumber);
        return mapCarToCarDto(car);
    }

    @Override
    public void deleteCar(String carNumber) {
        Car carFromDB = carRepository.findByCarNumber(carNumber)
                .orElseThrow(CarNotFoundException::new);
        carRepository.delete(carFromDB);
        log.info("CarService: delete car with carNumber {}", carNumber);
    }

    @Override
    public List<CarDto> findAllByBrand(String brand, int page, int size) {
        log.info("CarService: find cars by brand {}", brand);
        Pageable paging = PageRequest.of(page, size);
        return carRepository.findAllByBrand(brand, paging).stream()
                .map(this::mapCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> findAllByCarClass(String carClass, int page, int size) {
        log.info("CarService: find cars by carClass {}", carClass);
        Pageable paging = PageRequest.of(page, size);
        return carRepository.findAllByCarClass(carClass, paging).stream()
                .map(this::mapCarToCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> sortByPrice(int page, int size) {
        log.info("CarService: sort cars by price with order");
        Pageable paging = PageRequest.of(page, size, Sort.by("price").descending());
        return carRepository.findAll(paging)
                .stream()
                .map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> sortByName() {
        log.info("CarService: sort cars by name");
        return carRepository.findAllByOrderByBrandAscModelAsc()
                .stream()
                .map(this::mapCarToCarDto).collect(Collectors.toList());
    }

    public Car mapCarDtoToCar(CarDto carDto) {
        return Car.builder()
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .carClass(carDto.getCarClass())
                .price(carDto.getPrice())
                .carNumber(carDto.getCarNumber())
                .isAvailable(carDto.isAvailable())
                .build();
    }

    public CarDto mapCarToCarDto(Car car) {
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
