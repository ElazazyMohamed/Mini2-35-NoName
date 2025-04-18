package com.example.miniapp.models;
import jakarta.persistence.*;
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
