package com.tobeto.rentacarworkshop.services.dtos.category.request;

import lombok.Data;

@Data
public class DeleteCategoryRequest {
    private int id;
    private String name;
}
