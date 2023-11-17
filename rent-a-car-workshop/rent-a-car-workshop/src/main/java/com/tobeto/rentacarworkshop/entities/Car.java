package com.tobeto.rentacarworkshop.entities;

import jakarta.persistence.*;


import java.util.List;

@Table(name = "cars")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "daily_price")
    private double dailyPrice;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "car")
    private List<RentalProcess> rentalProcesses;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;


}
