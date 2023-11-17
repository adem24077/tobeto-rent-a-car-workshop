package com.tobeto.rentacarworkshop.entities;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "rental_processes")
@Entity
public class RentalProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "total_cost")
    private double total_date;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


}
