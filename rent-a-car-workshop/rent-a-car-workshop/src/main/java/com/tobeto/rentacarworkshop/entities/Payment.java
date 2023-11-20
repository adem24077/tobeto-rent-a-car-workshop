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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarHolderName() {
        return carHolderName;
    }

    public void setCarHolderName(String carHolderName) {
        this.carHolderName = carHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public List<RentalProcess> getRentalProcesses() {
        return rentalProcesses;
    }

    public void setRentalProcesses(List<RentalProcess> rentalProcesses) {
        this.rentalProcesses = rentalProcesses;
    }
}
