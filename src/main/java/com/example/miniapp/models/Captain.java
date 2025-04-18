package com.example.miniapp.models;
import jakarta.persistence.*;
@Entity
@Table
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
