package com.tobeto.rentacarworkshop.repositories;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    @Query("Select new com.tobeto.rentacarworkshop.services.dtos.brand.responses.GetListBrandResponse(b.id,b.name)" +
    "From Brand b Where b.name= :name")
    List<GetListBrandResponse> findByName(String name);
    List<Brand> getByNameStartingWith(String name);

}
