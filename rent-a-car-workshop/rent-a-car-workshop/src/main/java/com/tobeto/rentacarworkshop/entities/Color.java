package com.tobeto.rentacarworkshop.entities;


import jakarta.persistence.*;

import java.util.List;

@Table(name = "colors")
@Entity
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "color")
    private List<Car> cars;
}
