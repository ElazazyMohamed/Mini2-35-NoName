package com.example.miniapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;
    private double amount;
    private String paymentMethod;
    private boolean paymentStatus;


    @OneToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    // Constructors
    public Payment() {} // Default

    public Payment(Double amount, String paymentMethod, Boolean paymentStatus) { // Partial
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Payment(Long payment_id, Double amount, String paymentMethod, Boolean paymentStatus, Trip trip) { // Full
        this.payment_id = payment_id;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.trip = trip;
    }

    // Getters and Setters
    public long getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public boolean isPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public Trip getTrip() {
        return trip;
    }
    public void setTrip(Trip trip) {
        this.trip = trip;
    }





}
