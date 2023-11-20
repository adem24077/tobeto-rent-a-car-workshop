package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryRepository.findAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable int id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id, @RequestBody Category category) {
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow();
        categoryRepository.delete(categoryToDelete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Category category) {
        Category categoryToUpdate = categoryRepository.getOne(id);
        categoryToUpdate.setName(category.getName());
        categoryRepository.save(categoryToUpdate);
    }

}
