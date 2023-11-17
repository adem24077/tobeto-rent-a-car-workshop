package com.tobeto.rentacarworkshop.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Car> cars;
}
