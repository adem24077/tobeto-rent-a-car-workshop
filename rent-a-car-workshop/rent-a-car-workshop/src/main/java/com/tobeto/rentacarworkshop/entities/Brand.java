package com.tobeto.rentacarworkshop.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "brands")
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;


}
