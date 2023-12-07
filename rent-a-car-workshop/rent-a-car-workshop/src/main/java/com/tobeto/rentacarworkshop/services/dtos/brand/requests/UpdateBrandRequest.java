package com.tobeto.rentacarworkshop.services.dtos.brand.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {

    @Positive
    private int id;

    @NotBlank(message = "Marka adı boş bırakılamaz.")
    @Length(min = 3,message = "Marka adı 2 karakterden az olamaz.")
    private String name;
}
