package com.tobeto.rentacarworkshop.services.dtos.customer.request;

import lombok.Data;

@Data
public class UpdateCustomerRequest {
    private int id;
    private String name;
    private String surname;
    private String phone;
}
