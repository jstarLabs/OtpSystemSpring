package com.example.otpsystemspring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

}
