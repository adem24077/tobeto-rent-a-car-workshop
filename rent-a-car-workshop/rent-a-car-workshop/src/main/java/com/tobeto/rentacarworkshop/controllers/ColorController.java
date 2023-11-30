package com.tobeto.rentacarworkshop.controllers;

import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.services.abstracts.ColorService;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.responses.GetListColorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
public class ColorController {

    private ColorService colorService;
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }


    @PostMapping
    public void add(@RequestBody AddColorRequest request) {
        colorService.add(request);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody DeleteColorRequest request){
        colorService.delete(request);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateColorRequest request) {
        colorService.update(request);
    }

    @GetMapping
    public List<Color> getByNameStartingWith(@RequestParam String name){
        return colorService.getByNameStartWith(name);
    }

    @GetMapping("fName")
    public List<GetListColorResponse> getByName(@RequestParam String name){
        return colorService.getByName(name);
    }




}
