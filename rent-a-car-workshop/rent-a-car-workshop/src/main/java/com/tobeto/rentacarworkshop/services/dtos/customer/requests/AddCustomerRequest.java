package com.tobeto.rentacarworkshop.services.dtos.customer.requests;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String name;
    private String surname;
    private String phone;

}