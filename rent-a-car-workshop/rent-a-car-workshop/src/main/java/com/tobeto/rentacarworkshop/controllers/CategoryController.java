package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.repositories.CategoryRepository;
import com.tobeto.rentacarworkshop.services.abstracts.CategoryService;
import com.tobeto.rentacarworkshop.services.dtos.category.request.AddCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.request.DeleteCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.request.UpdateCategoryRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @PostMapping
    public void add(@RequestBody AddCategoryRequest request) {
        categoryService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteCategoryRequest request) {
        categoryService.delete(request);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateCategoryRequest request) {
        categoryService.update(request);
    }

}
