package com.tobeto.rentacarworkshop.services.abstracts;

import com.tobeto.rentacarworkshop.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.DeleteCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rentacarworkshop.services.dtos.car.responses.GetListCarResponse;

import java.util.List;

public interface CarService {
    void add(AddCarRequest request);
    void update(UpdateCarRequest request);
    void delete(DeleteCarRequest request);
    List<GetListCarResponse> getByModelYear(int modelYear);
    List<GetListCarResponse> getByDailyPrice(double dailyPrice);


}
