package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
