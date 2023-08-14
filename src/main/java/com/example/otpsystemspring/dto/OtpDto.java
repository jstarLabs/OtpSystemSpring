package com.example.otpsystemspring.dto;

import lombok.Data;

@Data
public class OtpDto {

    String uuid;
    String username;
    int otp;
}
