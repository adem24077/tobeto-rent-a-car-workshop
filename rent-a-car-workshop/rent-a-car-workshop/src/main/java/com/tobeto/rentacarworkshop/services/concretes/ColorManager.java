package com.tobeto.rentacarworkshop.services.concretes;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.repositories.ColorRepository;
import com.tobeto.rentacarworkshop.services.abstracts.ColorService;
import com.tobeto.rentacarworkshop.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.request.DeleteColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.request.UpdateColorRequest;
import org.springframework.stereotype.Service;

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
}
