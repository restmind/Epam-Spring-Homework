package com.epam.spring.web.mvc.rentcarservice.api;

import com.epam.spring.web.mvc.rentcarservice.controller.model.CarModel;
import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Car management API")
@RequestMapping("/api/v1/cars")
public interface CarApi {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<CarModel> getAvailableCars();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{carNumber}")
    CarModel getCar(@PathVariable String carNumber);

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CarModel createCar(@Valid @RequestBody CarDto carDto);

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/{carNumber}")
    CarModel updateCar(@PathVariable String carNumber, @RequestBody CarDto carDto);

    @DeleteMapping(value = "/{carNumber}")
    ResponseEntity<Void> deleteCar(@PathVariable String carNumber);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/filter/brand={brand}")
    List<CarModel> findCarsByBrand(@PathVariable String brand,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/filter/car_class={carClass}")
    List<CarModel> findCarsByCarClass(@PathVariable String carClass,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sort/price")
    List<CarModel> sortCarsByPrice(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "5") int size);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/sort/name")
    List<CarModel> sortCarsByName();
}
