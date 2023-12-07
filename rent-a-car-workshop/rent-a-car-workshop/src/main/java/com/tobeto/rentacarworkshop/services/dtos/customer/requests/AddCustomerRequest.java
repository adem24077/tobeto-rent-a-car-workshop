package com.tobeto.rentacarworkshop.services.dtos.customer.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {

    @NotBlank(message = "Müşteri adı boş olamaz.")
    private String name;

    @Length(min = 2,message = "Soyadı 2 karakterden az olamaz.")
    @NotBlank(message = "Soyadı boş bırakılamaz.")
    private String surname;

    @NotBlank
    @Length(min = 11,message = "Telefon numarası 11 rakamdan oluşmalıdır.")
    private String phone;

}
