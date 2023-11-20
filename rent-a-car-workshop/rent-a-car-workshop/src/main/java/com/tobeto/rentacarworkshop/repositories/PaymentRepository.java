package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
