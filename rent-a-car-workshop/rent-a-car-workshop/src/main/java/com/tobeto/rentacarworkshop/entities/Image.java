package com.tobeto.rentacarworkshop.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "images")
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "image")
    private List<Car> cars;


}
