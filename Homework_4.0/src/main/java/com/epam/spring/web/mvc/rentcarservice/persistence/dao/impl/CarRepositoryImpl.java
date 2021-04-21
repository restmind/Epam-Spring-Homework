package com.epam.spring.web.mvc.rentcarservice.persistence.dao.impl;

import com.epam.spring.web.mvc.rentcarservice.exception.CarNotFoundException;
import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CarRepositoryImpl implements CarRepository {
    private final List<Car> list = new ArrayList<>();

    @Override
    public List<Car> getCars() {
        log.info("Got list of cars");
        return list;
    }

    @Override
    public Car getCar(String carNumber) {
        log.info("Got car by carNumber: " + carNumber);
        return list.stream().filter(car -> car.getCarNumber().equals(carNumber))
                .findFirst().orElseThrow(CarNotFoundException::new);
    }

    @Override
    public Car createCar(Car car) {
        list.add(car);
        log.info("Created car: " + car);
        return car;
    }

    @Override
    public Car updateCar(String carNumber, Car car) {
        boolean isDeleted = list.removeIf(u -> u.getCarNumber().equals(carNumber));
        if (isDeleted) {
            list.add(car);
            log.info("Update car with carNumber: " + carNumber);
        } else {
            throw new CarNotFoundException();
        }
        return car;
    }

    @Override
    public void deleteCar(String carNumber) {
        list.removeIf(car -> car.getCarNumber().equals(carNumber));
        log.info("Car with carNumber {} was deleted", carNumber);
    }

    @Override
    public List<Car> findByBrand(String brand) {
        log.info("Found list of cars by brand {}", brand);
        return list.stream().filter(car -> car.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByCarClass(String carClass) {
        log.info("Found list of cars by carClass {}", carClass);
        return list.stream().filter(car -> car.getCarClass().equals(carClass)).collect(Collectors.toList());
    }
}
