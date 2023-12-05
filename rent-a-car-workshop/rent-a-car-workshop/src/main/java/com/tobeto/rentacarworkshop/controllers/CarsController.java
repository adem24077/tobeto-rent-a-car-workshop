package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.services.abstracts.CarService;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void add(@RequestBody AddCarRequest request) {
        carService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteCarRequest request) {
        carService.delete(request);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateCarRequest request){
        carService.update(request);
    }

    @GetMapping("modelYear")
    public List<GetListCarResponse> findByModelYear(@RequestParam int modelYear){
        return  carService.getByModelYear(modelYear);
    }
    @GetMapping
    public List<GetListCarResponse> getByDailyPrice(@RequestParam int dailyPrice){
        return carService.getByDailyPrice(dailyPrice);
    }
    @GetMapping("getAll")
    public List<GetListCarResponse> getAll() {
        return carService.getAll();
    }

}
