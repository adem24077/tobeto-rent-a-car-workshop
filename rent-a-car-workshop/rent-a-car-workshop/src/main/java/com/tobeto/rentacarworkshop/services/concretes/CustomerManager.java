package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Customer;
import com.tobeto.rentacarworkshop.repositories.CustomerRepository;
import com.tobeto.rentacarworkshop.services.abstracts.CustomerService;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void add(AddCustomerRequest request) {
        if (request.getName().length()<2)
            throw new RuntimeException("Müşteri adı 2'den az olamaz. ");

        Customer customer = new Customer();
        customer.setName(request.getName());
        customerRepository.save(customer);
    }

    @Override
    public void delete(DeleteCustomerRequest request) {
        Customer customerToDelete = customerRepository.findById(request.getId()).orElseThrow();
        customerRepository.delete(customerToDelete);

    }

    @Override
    public void update(UpdateCustomerRequest request) {
        Customer customerToUpdate = customerRepository.getOne(request.getId());
        customerToUpdate.setId(request.getId());
        customerToUpdate.setName(request.getName());
        customerToUpdate.setSurname(request.getSurname());
        customerToUpdate.setPhone(request.getPhone());
        customerRepository.save(customerToUpdate);

    }
}
