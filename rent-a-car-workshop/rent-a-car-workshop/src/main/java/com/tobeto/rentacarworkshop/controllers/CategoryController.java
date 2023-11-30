package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.services.abstracts.CategoryService;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.DeleteCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.responses.GetListCategoryResponse;
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

    @GetMapping
    public List<Category> getByNameStartingWith(@RequestParam String name){
        return categoryService.getNameStartWith(name);
    }

    @GetMapping("ctg")
    public List<GetListCategoryResponse> getByName(@RequestParam String name){
        return categoryService.getByName(name);
    }




}
