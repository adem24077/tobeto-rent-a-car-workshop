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
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    @NotBlank(message = "Marka alanı boş bırakılamaz.")
    private Brand brand;

    @NotBlank(message = "Renk alanı boş bırakılamaz.")
    private Color color;

    @NotBlank(message = "Kategori alanı boş bırakılamaz.")
    private Category category;

    @NotBlank(message = "Fotoğraf alanı boş bırakılamaz.")
    private Image image;

    @Min(value = 2003, message = "Model yılı en az 2005 olabilir.")
    private int modelYear;

    @Min(value = 250, message = "Kiralama bedeli 250'den az olamaz.")
    private double dailyPrice;

    @NotBlank(message = "Açıklama boş bırakılamaz.")
    private String description;

    @NotBlank
    @Length(min = 6)
    private String plate;

    @Positive(message = "Marka id numarası pozitif olmak zorunda.")
    private int brandId;

}
