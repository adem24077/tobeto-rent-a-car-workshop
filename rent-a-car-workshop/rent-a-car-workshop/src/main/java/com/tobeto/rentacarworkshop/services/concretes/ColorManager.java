package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.repositories.ColorRepository;
import com.tobeto.rentacarworkshop.services.abstracts.ColorService;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.responses.GetListColorResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorManager implements ColorService {

    private ColorRepository colorRepository;

    public ColorManager(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public void add(AddColorRequest request) {
        if (request.getName().length()<3)
            throw new RuntimeException("Renk adı 3 haneden az olamaz");

        Color color = new Color();
        color.setName(request.getName());
        colorRepository.save(color);
    }

    @Override
    public void delete(DeleteColorRequest request) {
        Color colorToDelete = colorRepository.findById(request.getId()).orElseThrow();
        colorRepository.delete(colorToDelete);

    }

    @Override
    public void update(UpdateColorRequest request) {
        Color colorToUpdate = colorRepository.getOne(request.getId());
        colorToUpdate.setName(request.getName());
        colorRepository.save(colorToUpdate);
    }

    public List<GetListColorResponse> getByName(String name){
        return colorRepository.findByName(name);
    }

    @Override
    public List<Color> getByNameStartWith(String name) {
        return colorRepository.getByNameStartingWith(name);
    }

    @Override
    public List<GetListColorResponse> getAll() {
        return colorRepository.findAll().stream().
                map(color -> new GetListColorResponse(color.getId(),color.getName())).toList();
    }


}
