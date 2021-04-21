package com.epam.spring.resttemplateservice.restTemplateService.service;

import com.epam.spring.resttemplateservice.restTemplateService.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class RentCarServiceClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public Car getCar(String carNumber) {

        String url = "http://localhost:8081/api/v1/cars/" + carNumber;
        log.info("{}", restTemplate.getForObject(url, Car.class));
        return restTemplate.getForObject(url, Car.class);
    }

    public void deleteCar(String carNumber) {
        String url = "http://localhost:8081/api/v1/cars/"+ carNumber;
        log.info("{}", restTemplate.getForObject(url, Car.class));
        restTemplate.delete(url);
    }

    public Car createCar(Car car) {
        String url = "http://localhost:8081/api/v1/cars/";
        return restTemplate.postForObject(url, car, Car.class);
    }

    public void updateCar(String carNumber, Car car) {
        String url = "http://localhost:8081/api/v1/cars/" + carNumber;
        restTemplate.put(url, car);
    }
}
