package com.example.otpsystemspring.service.Impl;

import com.example.otpsystemspring.dto.OtpDto;
import com.example.otpsystemspring.dto.OtpStatus;
import com.example.otpsystemspring.entity.Otp;
import com.example.otpsystemspring.entity.Users;
import com.example.otpsystemspring.exception.ServiceException;
import com.example.otpsystemspring.repository.OtpRepository;
import com.example.otpsystemspring.repository.UserRepository;
import com.example.otpsystemspring.service.ExpireOtpService;
import com.example.otpsystemspring.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private ExpireOtpService expireOtpService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OtpDto generateOtpForUser( String username ) {
        // expire previous otp requested 2 min older if any for all users.
        expireOtpService.expireOtp();
        // Check if active otp already there or not
        Otp otp = otpRepository.getOtpByUser_UserNameAndOtpStatus(username, OtpStatus.Active);

        if (otp != null) {
            throw new ServiceException("Otp already sent");
        }

        otp = new Otp();

        Users user = userRepository.getUserByUserName(username);
        otp.setOtpStatus(OtpStatus.Active);
        otp.setVerified(false);
        otp.setUser(user);
        otp.setUuid(UUID.randomUUID().toString());
        otp.setCreatedAt(new Date());
        otp.setOtp(generateOtp());

        Otp newOtp = otpRepository.save(otp);

        return convertToDto(newOtp);
    }

    private OtpDto convertToDto( Otp newOtp ) {

        OtpDto otpDto = new OtpDto();

        otpDto.setOtp(newOtp.getOtp());
        otpDto.setUsername(newOtp.getUser().getUserName());
        otpDto.setUuid(newOtp.getUuid());

        return otpDto;
    }


    private int generateOtp() {
        Random random = new Random();
        return random.nextInt(999999-100000+1) + 999999;
    }


    @Override
    public boolean verifyOtp( OtpDto otpDto ) {
        // Verify with request origin requested user,
        Otp otp = otpRepository.getOtpByUser_UserNameAndOtpStatusAndVerifiedAndUuidAndOtp(otpDto.getUsername(), OtpStatus.Active, false, otpDto.getUuid(), otpDto.getOtp());

        if (otp != null) {
            otp.setVerified(true);
            otp.setVerifiedAt(new Date());
            otpRepository.save(otp);
            return true;
        }
        return false;
    }
}
