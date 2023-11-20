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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<RentalProcess> getRentalProcesses() {
        return rentalProcesses;
    }

    public void setRentalProcesses(List<RentalProcess> rentalProcesses) {
        this.rentalProcesses = rentalProcesses;
    }
}
