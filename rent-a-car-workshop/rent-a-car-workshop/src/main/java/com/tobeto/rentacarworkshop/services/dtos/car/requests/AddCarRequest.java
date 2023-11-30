package com.tobeto.rentacarworkshop.services.dtos.car.requests;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.entities.Image;
import lombok.Data;

@Data
public class AddCarRequest {
    private Brand brand;
    private Color color;
    private Category category;
    private Image image;
    private int modelYear;
    private double dailyPrice;
    private String description;

}
