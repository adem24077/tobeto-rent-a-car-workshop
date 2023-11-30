package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.services.dtos.image.requests.AddImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.requests.DeleteImageRequest;
import com.tobeto.rentacarworkshop.services.dtos.image.requests.UpdateImageRequest;

public interface ImageService {
    void add(AddImageRequest request);
    void delete(DeleteImageRequest request);

    void update(UpdateImageRequest request);
}
