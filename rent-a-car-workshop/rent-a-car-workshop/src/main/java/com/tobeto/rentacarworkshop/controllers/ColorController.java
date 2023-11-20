package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.repositories.BrandRepository;
import com.tobeto.rentacarworkshop.repositories.ColorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorController {
    private final ColorRepository colorRepository;

    public ColorController(ColorRepository colorRepository){
        this.colorRepository = colorRepository;
    }

    @GetMapping
    public List<Color> getAll() {
        List<Color> colors = colorRepository.findAll();
        return colorRepository.findAll();
    }

    @GetMapping("{id}")
    public Color getById(@PathVariable int id) {
        return colorRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public void add(@RequestBody Color color) {
        colorRepository.save(color);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        Color colorToDelete = colorRepository.findById(id).orElseThrow();
        colorRepository.delete(colorToDelete);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Color color) {
        Color colorToUpdate = colorRepository.getOne(id);
        colorToUpdate.setName(color.getName());
        colorRepository.save(colorToUpdate);
    }




}
