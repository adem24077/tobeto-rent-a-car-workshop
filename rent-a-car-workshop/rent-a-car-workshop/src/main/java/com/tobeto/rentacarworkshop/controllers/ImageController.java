package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Image;
import com.tobeto.rentacarworkshop.repositories.ImageRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImageController {
    private final ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository){
        this.imageRepository=imageRepository;
    }

    @GetMapping
    public List<Image> getAll() {
        List<Image> images = imageRepository.findAll();
        return imageRepository.findAll();
    }

    @GetMapping("{id}")
    public Image getById(@PathVariable int id) {
        return imageRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Image image) {
        imageRepository.save(image);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Image imageToDelete = imageRepository.findById(id).orElseThrow();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Image image) {
        Image imageToUpdate = imageRepository.getOne(id);
        imageToUpdate.setCars(image.getCars());
        imageRepository.save(imageToUpdate);
    }




}
