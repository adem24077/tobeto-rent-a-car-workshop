package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Customer;
import com.tobeto.rentacarworkshop.repositories.CustomerRepository;
import com.tobeto.rentacarworkshop.services.abstracts.CategoryService;
import com.tobeto.rentacarworkshop.services.abstracts.CustomerService;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.UpdateCustomerRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void add(@RequestBody AddCustomerRequest request) {
        customerService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteCustomerRequest request) {
        customerService.delete(request);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateCustomerRequest request) {
        customerService.update(request);
    }

}
