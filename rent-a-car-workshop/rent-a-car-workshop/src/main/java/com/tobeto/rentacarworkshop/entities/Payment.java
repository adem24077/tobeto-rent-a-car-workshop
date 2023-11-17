package com.tobeto.rentacarworkshop.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "payments")
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "car_holder_name")
    private String carHolderName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "cvv")
    private int cvv;

    @OneToMany(mappedBy = "payment")
    private List<RentalProcess> rentalProcesses;




}
