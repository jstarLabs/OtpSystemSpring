package com.example.otpsystemspring.entity;

import com.example.otpsystemspring.dto.OtpStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    private int otp;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "is_verified", nullable = false)
    private boolean verified =false;

    @Column(name = "verified_at")
    private Date verifiedAt;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private Users user;

    @Column(name = "otp_status",nullable = false)
    private OtpStatus otpStatus;



}
