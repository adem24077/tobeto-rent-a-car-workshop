package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.repositories.CategoryRepository;
import com.tobeto.rentacarworkshop.services.abstracts.CategoryService;
import com.tobeto.rentacarworkshop.services.dtos.category.request.AddCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.request.DeleteCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.request.UpdateCategoryRequest;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;
    public CategoryManager(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void add(AddCategoryRequest request) {
        if (request.getName().length()<4)
            throw new RuntimeException("Kategori karakter sayısı 4'ten az olamaz.");

        Category category = new Category();
        category.setName(request.getName());
        categoryRepository.save(category);

    }

    @Override
    public void delete(DeleteCategoryRequest request) {
        Category categoryToDelete = categoryRepository.findById(request.getId()).orElseThrow();
        categoryRepository.delete(categoryToDelete);
    }

    @Override
    public void update(UpdateCategoryRequest request) {
        Category categoryToUpdate = categoryRepository.getOne(request.getId());
        categoryToUpdate.setName(request.getName());
        categoryRepository.save(categoryToUpdate);

    }
}
