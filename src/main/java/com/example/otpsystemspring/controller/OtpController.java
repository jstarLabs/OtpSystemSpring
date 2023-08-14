package com.example.otpsystemspring.controller;

import com.example.otpsystemspring.dto.HttpResponse;
import com.example.otpsystemspring.dto.OtpDto;
import com.example.otpsystemspring.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @GetMapping("/request/{userName}")
    public HttpResponse requestOtp( @PathVariable String userName) {
        try {

            return new HttpResponse("Success", otpService.generateOtpForUser(userName));
        } catch (Exception e) {
            return new HttpResponse("Fail", e.getMessage());
        }
    }

    @PostMapping("/verify")
    public HttpResponse verifyOtp( @RequestBody OtpDto otp) {
        try {
            boolean isVerified = otpService.verifyOtp(otp);
            return new HttpResponse("Success", isVerified);
        } catch (Exception e) {
            return new HttpResponse("Fail", false);
        }
    }



}
