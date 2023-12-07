package com.tobeto.rentacarworkshop.services.dtos.customer.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @Positive(message = "Müşteri id boş geçilemez.")
    private int id;

    @NotBlank(message = "Müşteri adı boş olamaz.")
    private String name;

    @Length(min = 2,message = "Soyadı 2 karakterden az olamaz.")
    @NotBlank
    private String surname;

    @NotBlank
    @Length(min = 11,message = "Telefon numarası 11 rakamdan oluşmalıdır.")
    private String phone;
}
