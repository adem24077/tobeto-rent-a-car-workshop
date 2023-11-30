package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Customer;
import com.tobeto.rentacarworkshop.services.dtos.customer.responses.GetListCustomerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("Select new com.tobeto.rentacarworkshop.services.dtos.customer.responses.GetListCustomerResponse(c.name,c.surname) " +
            "From Customer c WHERE c.name= :name")
    List<GetListCustomerResponse> findByName(String name);

    List<Customer> findBySurname(String surname);


}
