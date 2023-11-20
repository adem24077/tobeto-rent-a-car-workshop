package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Customer;
import com.tobeto.rentacarworkshop.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer getById(@PathVariable int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Customer customerToDelete = customerRepository.findById(id).orElseThrow();
        customerRepository.delete(customerToDelete);

    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Customer customer) {
        Customer customerToUpdate = customerRepository.getOne(id);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setSurname(customer.getSurname());
        customerToUpdate.setPhone(customer.getPhone());
        customerToUpdate.setRentalProcesses(customer.getRentalProcesses());
    }

}
