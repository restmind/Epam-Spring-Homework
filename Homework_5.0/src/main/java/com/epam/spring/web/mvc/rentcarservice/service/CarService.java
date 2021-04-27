package com.epam.spring.web.mvc.rentcarservice.service;


import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAvailableCars();

    CarDto getCar(String carNumber);

    CarDto createCar(CarDto carDto);

    CarDto updateCar(String carNumber, CarDto carDto);

    void deleteCar(String carNumber);

    List<CarDto> findAllByBrand(String brand, int page, int size);

    List<CarDto> findAllByCarClass(String carClass, int page, int size);

    List<CarDto> sortByPrice(int page, int size);

    List<CarDto> sortByName();
}
