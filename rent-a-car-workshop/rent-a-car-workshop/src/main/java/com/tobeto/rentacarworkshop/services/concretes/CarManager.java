package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Car;
import com.tobeto.rentacarworkshop.repositories.CarRepository;
import com.tobeto.rentacarworkshop.services.abstracts.CarService;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.responses.GetListCarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {

    private CarRepository carRepository;
    public CarManager(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public void add(AddCarRequest request) {
        Car car = new Car();
        car.setBrand(request.getBrand());
        car.setCategory(request.getCategory());
        car.setColor(request.getColor());
        car.setImage(request.getImage());
        car.setDescription(request.getDescription());
        car.setDailyPrice(request.getDailyPrice());
        car.setModelYear(request.getModelYear());
        carRepository.save(car);
    }
    @Override
    public void update(UpdateCarRequest request) {
        Car carToUpdate = carRepository.getOne(request.getId());
        carToUpdate.setBrand(carToUpdate.getBrand());
        carToUpdate.setCategory(request.getCategory());
        carToUpdate.setColor(request.getColor());
        carToUpdate.setImage(request.getImage());
        carToUpdate.setDescription(request.getDescription());
        carToUpdate.setDailyPrice(carToUpdate.getDailyPrice());
        carToUpdate.setModelYear(carToUpdate.getModelYear());
        carRepository.save(carToUpdate);
    }
    @Override
    public void delete(DeleteCarRequest request) {
        Car carToDelete = carRepository.findById(request.getId()).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public List<GetListCarResponse> getByModelYear(int modelYear) {
        return carRepository.findByModelYear(modelYear);
    }

    @Override
    public List<GetListCarResponse> getByDailyPrice(double dailyPrice) {
        return carRepository.findByDailyPrice(dailyPrice);
    }


}
