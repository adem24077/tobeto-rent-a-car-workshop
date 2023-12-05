package com.tobeto.rentacarworkshop.services.dtos.car.responses;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class GetListCarResponse {
    private int id;
    private double dailyPrice;
    private int modelYear;
    private GetListBrandResponse brand;
}
