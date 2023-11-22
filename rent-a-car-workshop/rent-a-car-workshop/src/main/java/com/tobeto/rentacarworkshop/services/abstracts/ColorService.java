package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.services.dtos.color.request.AddColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.request.DeleteColorRequest;
import com.tobeto.rentacarworkshop.services.dtos.color.request.UpdateColorRequest;
import org.springframework.stereotype.Service;

public interface ColorService {
    void add(AddColorRequest request);
    void delete(DeleteColorRequest request);
    void update(UpdateColorRequest request);
}
