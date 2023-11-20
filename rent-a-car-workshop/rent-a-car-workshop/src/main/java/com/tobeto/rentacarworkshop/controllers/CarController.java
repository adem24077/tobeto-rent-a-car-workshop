package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Car;
import com.tobeto.rentacarworkshop.repositories.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll() {
        List<Car> cars = carRepository.findAll();
        return carRepository.findAll();
    }

    @GetMapping("{id}")
    public Car getById(@PathVariable int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Car car) {
        carRepository.save(car);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Car car){
        Car carToUpdate = carRepository.getOne(id);
        carToUpdate.setModelYear(car.getModelYear());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setColor(car.getColor());
        carToUpdate.setDailyPrice(car.getDailyPrice());
        carToUpdate.setCategory(car.getCategory());
        carToUpdate.setImage(car.getImage());
        carToUpdate.setDescription(car.getDescription());
    }

}
