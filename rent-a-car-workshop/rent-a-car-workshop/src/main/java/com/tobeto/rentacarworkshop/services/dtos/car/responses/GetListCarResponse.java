package com.tobeto.rentacarworkshop.services.dtos.car.responses;

import com.tobeto.rentacarworkshop.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCarResponse {
    private int id;
    private double daily;
    private int modelYear;
}
