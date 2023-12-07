package com.tobeto.rentacarworkshop.services.dtos.car.requests;

import com.tobeto.rentacarworkshop.entities.Brand;
import com.tobeto.rentacarworkshop.entities.Category;
import com.tobeto.rentacarworkshop.entities.Color;
import com.tobeto.rentacarworkshop.entities.Image;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @Positive
    private int id;

    @NotBlank(message = "Marka alanı boş bırakılamaz.")
    private Brand brand;

    @NotBlank(message = "Renk alanı boş bırakılamaz. ")
    private Color color;

    @NotBlank(message = "Kategori adı boş bırakılamaz.")
    private Category category;
    @NotBlank(message = "Fotoğraf alanı boş bırakılamaz.")
    private Image image;

    @Min(value = 2004,message = "Model yılı en az 2004 olabilir.")
    private int modelYear;

    @Min(value = 250,message = "Kiralama bedeli 250'den az olamaz.")
    @Positive(message = "Kiralama bedeli pozitif olmak zorundadır.")
    private double dailyPrice;

    @NotBlank(message = "Tanım boş olamaz.")
    private String description;

}
