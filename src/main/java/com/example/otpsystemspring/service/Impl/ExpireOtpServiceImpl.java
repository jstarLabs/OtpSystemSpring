package com.example.otpsystemspring.service.Impl;

import com.example.otpsystemspring.dto.OtpStatus;
import com.example.otpsystemspring.repository.OtpRepository;
import com.example.otpsystemspring.service.ExpireOtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class ExpireOtpServiceImpl implements ExpireOtpService {

    @Autowired
    OtpRepository otpRepository;

    private static final int minToExpire = 2;

    @Override
    public void expireOtp() {
        LocalDateTime timeToExpire = LocalDateTime.now().minus(minToExpire, ChronoUnit.MINUTES);
        otpRepository.updateOtpStatusToExpired(OtpStatus.Expired, Date.from(timeToExpire.atZone(ZoneId.systemDefault()).toInstant()));
    }

}
