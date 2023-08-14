package com.example.otpsystemspring.service;

import com.example.otpsystemspring.dto.OtpDto;

public interface OtpService {

    OtpDto generateOtpForUser( String username);
    boolean verifyOtp(OtpDto otp);

}
