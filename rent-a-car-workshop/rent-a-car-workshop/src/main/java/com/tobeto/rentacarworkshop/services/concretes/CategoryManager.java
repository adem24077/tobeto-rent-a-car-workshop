package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.repositories.CategoryRepository;
import com.tobeto.rentacarworkshop.services.abstracts.CategoryService;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.AddCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.DeleteCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.requests.UpdateCategoryRequest;
import com.tobeto.rentacarworkshop.services.dtos.category.responses.GetListCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (request.getName().equals("Ağır Vasıta")){
            throw new IllegalStateException("Bu kategori sisteme eklenememektedir.");
        }

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

    @Override
    public List<Category> getNameStartWith(String name) {
        return categoryRepository.findByNameStartingWith(name);
    }

    @Override
    public List<GetListCategoryResponse> getByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<GetListCategoryResponse> getAll() {
        return categoryRepository.findAll().stream().
                map(category -> new GetListCategoryResponse(category.getId(),category.getName())).toList();
    }
}
