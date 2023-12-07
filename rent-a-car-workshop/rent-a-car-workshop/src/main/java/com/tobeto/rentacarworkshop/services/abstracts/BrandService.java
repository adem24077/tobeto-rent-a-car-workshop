package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.responses.GetListBrandResponse;

import java.util.List;

public interface BrandService {
    void add(AddBrandRequest request);
    void update(UpdateBrandRequest request);
    void delete(DeleteBrandRequest request);
    List<GetListBrandResponse> getByName(String name);
    List<Brand> getByNameStartWith(String name);
    List<String> getAll();
    Brand getById(int id);


}
