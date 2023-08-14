package com.example.otpsystemspring.controller;

import com.example.otpsystemspring.service.ExpireOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("otp/expire")
public class ExpireOtpController {

    @Autowired
    private ExpireOtpService expireOtpService;


    @GetMapping
    public String expireOtp() {
        expireOtpService.expireOtp();
        return "SUCCESS";
    }

}
