package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Image;
import com.tobeto.rentacarworkshop.repositories.ImageRepository;
import com.tobeto.rentacarworkshop.services.abstracts.ImageService;
import com.tobeto.rentacarworkshop.services.dtos.image.request.AddImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.request.DeleteImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.request.UpdateImageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageController {
    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public void add(@RequestBody AddImageRequest request) {
        imageService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteImageRequest request) {
        imageService.delete(request);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateImageRequest request) {
        imageService.update(request);
    }


}
