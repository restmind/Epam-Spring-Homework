package com.epam.spring.web.mvc.rentcarservice.service;


import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;


import java.util.List;

public interface CarService {
    List<CarDto> getCars();

    CarDto getCar(String carNumber);

    CarDto createCar(CarDto carDto);

    CarDto updateCar(String carNumber, CarDto carDto);

    void deleteCar(String carNumber);

    List<CarDto> findByBrand(String brand);

    List<CarDto> findByCarClass(String carClass);

    List<CarDto> sortByRentPrice(String order);

    List<CarDto> sortByName(String order);
}
