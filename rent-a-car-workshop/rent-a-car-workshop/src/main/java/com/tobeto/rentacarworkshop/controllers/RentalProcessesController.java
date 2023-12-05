package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.RentalProcess;
import com.tobeto.rentacarworkshop.repositories.RentalProcessRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentalprocesses")
public class RentalProcessesController {

    private final RentalProcessRepository rentalProcessRepository;

    public RentalProcessesController(RentalProcessRepository rentalProcessRepository) {
        this.rentalProcessRepository = rentalProcessRepository;
    }

    @GetMapping()
    public List<RentalProcess> getAll(){
        List<RentalProcess> rentalProcesses = rentalProcessRepository.findAll();
        return rentalProcessRepository.findAll();
    }

    @GetMapping("{id}")
    public RentalProcess getById(@PathVariable int id) {
        return rentalProcessRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody RentalProcess rentalProcess) {
        rentalProcessRepository.save(rentalProcess);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        RentalProcess rentalProcessToDelete = rentalProcessRepository.findById(id).orElseThrow();
        rentalProcessRepository.delete(rentalProcessToDelete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody RentalProcess rentalProcess) {
        RentalProcess rentalProcessToUpdate = rentalProcessRepository.getOne(id);
        rentalProcessToUpdate.setCar(rentalProcess.getCar());
        rentalProcessToUpdate.setCustomer(rentalProcess.getCustomer());
        rentalProcessToUpdate.setEnd_date(rentalProcess.getEnd_date());
        rentalProcessToUpdate.setStart_date(rentalProcess.getStart_date());
        rentalProcessToUpdate.setPayment(rentalProcess.getPayment());
        rentalProcessToUpdate.setTotal_date(rentalProcess.getTotal_date());
    }


}
