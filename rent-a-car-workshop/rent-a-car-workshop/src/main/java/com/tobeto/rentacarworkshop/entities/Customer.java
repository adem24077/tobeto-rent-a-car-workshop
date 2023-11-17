package com.tobeto.rentacarworkshop.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<RentalProcess> rentalProcesses;


}
