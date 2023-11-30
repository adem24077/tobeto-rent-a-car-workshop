package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.AddColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.DeleteColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.responses.GetListColorResponse;

import java.util.List;

public interface ColorService {
    void add(AddColorRequest request);
    void delete(DeleteColorRequest request);
    void update(UpdateColorRequest request);
    List<GetListColorResponse> getByName(String name);
    List<Color> getByNameStartWith(String name);

}
