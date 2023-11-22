package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.services.dtos.category.request.AddCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.request.DeleteCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.request.UpdateCategoryRequest;

public interface CategoryService {
    void add(AddCategoryRequest request);
    void delete(DeleteCategoryRequest request);
    void update(UpdateCategoryRequest request);
}
