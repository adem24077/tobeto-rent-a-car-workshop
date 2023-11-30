package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.entities.Customer;
import com.tobeto.rentacarworkshop.services.dtos.customer.responses.GetListCustomerResponse;
import com.tobeto.rentacarworkshop.services.dtos.customer.requests.AddCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.requests.DeleteCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.requests.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    void update(UpdateCustomerRequest request);
    List<GetListCustomerResponse> getByName(String name);
    List<Customer> getBySurname(String surname);

}
