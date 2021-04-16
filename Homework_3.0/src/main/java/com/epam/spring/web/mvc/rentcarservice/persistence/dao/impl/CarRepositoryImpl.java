package com.epam.spring.web.mvc.rentcarservice.persistence.dao.impl;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;
import com.epam.spring.web.mvc.rentcarservice.persistence.dao.CarRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarRepositoryImpl implements CarRepository {
    private final List<Car> list = new ArrayList<>();

    @Override
    public List<Car> getCars() {
        return list;
    }

    @Override
    public Car getCar(String carNumber) {
        return list.stream().filter(car -> car.getCarNumber().equals(carNumber))
                .findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public Car createCar(Car car) {
        list.add(car);
        return car;
    }

    @Override
    public Car updateCar(String carNumber, Car car) {
        boolean isDeleted = list.removeIf(u -> u.getCarNumber().equals(carNumber));
        if (isDeleted) {
            list.add(car);
        } else {
            throw new RuntimeException("Car does not exists");
        }
        return car;
    }

    @Override
    public void deleteCar(String carNumber) {
        list.removeIf(car -> car.getCarNumber().equals(carNumber));
    }

    @Override
    public List<Car> findByBrand(String brand) {
        return list.stream().filter(car -> car.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByCarClass(String carClass) {
        return list.stream().filter(car -> car.getCarClass().equals(carClass)).collect(Collectors.toList());
    }
}
