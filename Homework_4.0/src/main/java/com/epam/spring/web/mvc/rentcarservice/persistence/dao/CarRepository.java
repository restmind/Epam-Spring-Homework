package com.epam.spring.web.mvc.rentcarservice.persistence.dao;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.Car;

import java.util.List;

public interface CarRepository {

    List<Car> getCars();

    Car getCar(String carNumber);

    Car createCar(Car car);

    Car updateCar(String carNumber, Car car);

    void deleteCar(String carNumber);

    List<Car> findByBrand(String brand);

    List<Car> findByCarClass(String carClass);

}
