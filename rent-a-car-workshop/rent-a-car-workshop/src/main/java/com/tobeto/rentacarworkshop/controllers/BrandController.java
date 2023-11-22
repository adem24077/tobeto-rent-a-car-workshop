package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.repositories.BrandRepository;
import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.services.abstracts.BrandService;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController {

    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
   public void add(@RequestBody AddBrandRequest request){
       brandService.add(request);
  }

  @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteBrandRequest request){
        brandService.delete(request);
  }

  @PostMapping("/update/{id}")
    public void update(@RequestBody UpdateBrandRequest request) {
        brandService.update(request);
  }




}
