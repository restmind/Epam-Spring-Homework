package com.epam.spring.resttemplateservice.restTemplateService.service;

import com.epam.spring.resttemplateservice.restTemplateService.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentCarServiceService {
    private final RentCarServiceClient rentCarServiceClient;

    public Car getCar(String carNumber) {
        return rentCarServiceClient.getCar(carNumber);
    }

    public void deleteCar(String carNumber) {
         rentCarServiceClient.deleteCar(carNumber);
    }

    public Car createCar(Car car) {
        return rentCarServiceClient.createCar(car);
    }

    public void updateCar(String carNumber, Car car) {
        rentCarServiceClient.updateCar(carNumber, car);
    }
}
