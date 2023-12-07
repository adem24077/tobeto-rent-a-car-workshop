package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.repositories.BrandRepository;
import com.tobeto.rentacarworkshop.services.abstracts.BrandService;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.UpdateBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.responses.GetListBrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(AddBrandRequest request) {

        if (request.getName().length()<3)
            throw new RuntimeException("Marka ismi 3 haneden küçük olamaz");

        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        if (request.getName().length()<3)
            throw new RuntimeException("Marka ismi 3 haneden küçük olamaz");

        Brand brandToUpdate = brandRepository.getOne(request.getId());
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }

    @Override
    public List<GetListBrandResponse> getByName(String name) {
        List<GetListBrandResponse> brands = brandRepository.findByName(name);
        return brands.stream().map(brand -> new GetListBrandResponse(brand.getId(),brand.getName())).
                collect(Collectors.toList());
    }

    /*@Override
    public List<GetListBrandResponse> getByName(String name) {
        return brandRepository.findByName(name);
    }*/

    @Override
    public List<Brand> getByNameStartWith(String name) {
        return brandRepository.getByNameStartingWith(name);
    }

    @Override
    public List<String> getAll() {
        return brandRepository.findAll().stream().map(Brand::getName).collect(Collectors.toList());
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow();
    }

}
