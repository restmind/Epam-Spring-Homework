package com.epam.spring.web.mvc.rentcarservice.controller.assembler;

import com.epam.spring.web.mvc.rentcarservice.controller.CarController;
import com.epam.spring.web.mvc.rentcarservice.controller.model.CarModel;
import com.epam.spring.web.mvc.rentcarservice.dto.CarDto;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CarAssembler extends RepresentationModelAssemblerSupport<CarDto, CarModel> {
    public CarAssembler() {
        super(CarController.class, CarModel.class);
    }

    @Override
    public CarModel toModel(CarDto entity) {
        CarModel carModel = new CarModel(entity);
        Link get = linkTo(methodOn(CarController.class).getCar(entity.getCarNumber())).withRel("get");
        Link create = linkTo(methodOn(CarController.class).createCar(entity)).withRel("create");
        Link update = linkTo(methodOn(CarController.class).updateCar(entity.getCarNumber(), entity))
                .withRel("update");
        Link delete = linkTo(methodOn(CarController.class).deleteCar(entity.getCarNumber()))
                .withRel("delete");

        carModel.add(get, create, update, delete);
        return carModel;
    }
}
