package com.tobeto.rentacarworkshop.services.dtos.category.requests;

import lombok.Data;

@Data
public class UpdateCategoryRequest {
    private int id;
    private String name;
}
