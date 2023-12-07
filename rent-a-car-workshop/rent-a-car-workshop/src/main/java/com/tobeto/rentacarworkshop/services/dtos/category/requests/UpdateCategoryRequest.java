package com.tobeto.rentacarworkshop.services.dtos.category.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    @Positive
    private int id;

    @NotBlank(message = "Kategori alanını boş bırakılamaz.")
    private String name;
}
