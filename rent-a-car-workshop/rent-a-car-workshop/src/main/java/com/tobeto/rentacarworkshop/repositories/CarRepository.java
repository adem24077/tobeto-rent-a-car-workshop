package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Car;
import com.tobeto.rentacarworkshop.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {


    @Query("Select new com.tobeto.rentacarworkshop.services.dtos.car.responses.GetListCarResponse(c.modelYear,c.dailyPrice)" +
    "From Car c WHERE c.modelYear= :modelYear")
    List<GetListCarResponse> findByModelYear(int modelYear);
    @Query("Select new com.tobeto.rentacarworkshop.services.dtos.car.responses.GetListCarResponse(c.modelYear,c.dailyPrice)" +
    "From Car c Where c.dailyPrice= :dailyPrice")
    List<GetListCarResponse> findByDailyPrice(double dailyPrice);


}
