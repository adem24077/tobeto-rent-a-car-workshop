package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Payment;
import com.tobeto.rentacarworkshop.repositories.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/payments")
public class PaymentsController {
    private final PaymentRepository paymentRepository;

    public PaymentsController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        return paymentRepository.findAll();
    }

    @GetMapping("{id}")
    public Payment getById(@PathVariable int id) {
        return paymentRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Payment payment) {
        paymentRepository.save(payment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Payment paymentToDelete = paymentRepository.findById(id).orElseThrow();
        paymentRepository.delete(paymentToDelete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Payment payment){
        Payment paymentToUpdate = paymentRepository.getOne(id);
        paymentToUpdate.setCvv(payment.getCvv());
        paymentToUpdate.setCardNumber(payment.getCardNumber());
        paymentToUpdate.setCarHolderName(payment.getCarHolderName());
        paymentToUpdate.setExpiryDate(payment.getExpiryDate());
        paymentToUpdate.setRentalProcesses(payment.getRentalProcesses());
        paymentRepository.save(paymentToUpdate);
    }


}
