package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.services.dtos.image.request.AddImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.request.DeleteImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.request.UpdateImageRequest;

public interface ImageService {
    void add(AddImageRequest request);
    void delete(DeleteImageRequest request);

    void update(UpdateImageRequest request);
}
