package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.services.dtos.category.responses.GetListCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByNameStartingWith(String name);


    @Query("Select new com.tobeto.rentacarworkshop.services.dtos.category.responses.GetListCategoryResponse(b.id,b.name)" +
            "From Brand b WHERE b.name= :name ")
    List<GetListCategoryResponse> findByName(String name);
}
