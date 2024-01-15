package com.example.advancedworking;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CarController {
    private final CarRepository repository;


    private final CarModelAssembler assembler;


    CarController(CarRepository repository, CarModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    // Aggregate root
    // tag::get-aggregate-root[]

    @GetMapping("/cars")
    CollectionModel<EntityModel<Car>> all() {

        List<EntityModel<Car>> cars = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(cars, linkTo(methodOn(CarController.class).all()).withSelfRel());
    }

    // end::get-aggregate-root[]

    @PostMapping("/cars")
    Car newCar(@RequestBody Car newCar) {
        return repository.save(newCar);
    }

    // Single item

    @GetMapping("/cars/{id}")
    EntityModel<Car> one(@PathVariable Long id) {

        Car car = repository.findById(id) //
                .orElseThrow(() -> new CarNotFoundException(id));

        return assembler.toModel(car);
    }

    @PutMapping("/cars/{id}")
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

        return repository.findById(id)
                .map(Car -> {
                    Car.setName(newCar.getName());
                    Car.setManYear(newCar.getManYear());
                    Car.setcarModel(newCar.getcarModel());
                    return repository.save(Car);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return repository.save(newCar);
                });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
