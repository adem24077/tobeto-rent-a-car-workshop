package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Image;
import com.tobeto.rentacarworkshop.repositories.ImageRepository;
import com.tobeto.rentacarworkshop.services.abstracts.ImageService;
import com.tobeto.rentacarworkshop.services.dtos.image.request.AddImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.request.DeleteImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.request.UpdateImageRequest;
import org.springframework.stereotype.Service;

@Service
public class ImageManager implements ImageService {

    private ImageRepository imageRepository;

    public ImageManager(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void add(AddImageRequest request) {
        Image image = new Image();
        imageRepository.save(image);
    }

    @Override
    public void delete(DeleteImageRequest request) {
        Image imageToDelete = imageRepository.findById(request.getId()).orElseThrow();
        imageRepository.delete(imageToDelete);

    }

    @Override
    public void update(UpdateImageRequest request) {
        Image imageToUpdate = imageRepository.getOne(request.getId());
        imageToUpdate.setId(request.getId());
        imageRepository.save(imageToUpdate);

    }
}
