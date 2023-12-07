package com.tobeto.rentacarworkshop.services.dtos.color.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {

    @Positive(message = "Color id'si negatif olamaz.")
    private int id;

    @NotBlank(message = "Renk adı alanı boş bırakılamaz.")
    private String name;
}
