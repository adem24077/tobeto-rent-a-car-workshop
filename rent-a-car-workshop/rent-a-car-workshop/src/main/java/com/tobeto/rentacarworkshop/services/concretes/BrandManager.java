package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.repositories.BrandRepository;
import com.tobeto.rentacarworkshop.services.abstracts.BrandService;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.AddBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.DeleteBrandRequest;
import com.tobeto.rentacarworkshop.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.stereotype.Service;

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
        Brand brandToUpdate = brandRepository.getOne(request.getId());
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
    }

    @Override
    public void delete(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId()).orElseThrow();
        brandRepository.delete(brandToDelete);
    }


}
