package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.DeleteCustomerRequest;
import com.tobeto.rentacarworkshop.services.dtos.customer.request.UpdateCustomerRequest;

public interface CustomerService {
    void add(AddCustomerRequest request);
    void delete(DeleteCustomerRequest request);
    void update(UpdateCustomerRequest request);

}
