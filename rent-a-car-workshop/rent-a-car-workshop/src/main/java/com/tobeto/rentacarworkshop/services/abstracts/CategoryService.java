package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.DeleteCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.responses.GetListCategoryResponse;

import java.util.List;

public interface CategoryService {
    void add(AddCategoryRequest request);
    void delete(DeleteCategoryRequest request);
    void update(UpdateCategoryRequest request);
    List<Category> getNameStartWith(String name);
    List<GetListCategoryResponse> getByName(String name);
}
