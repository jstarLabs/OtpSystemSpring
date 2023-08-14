package com.example.otpsystemspring.repository;

import com.example.otpsystemspring.dto.OtpStatus;
import com.example.otpsystemspring.entity.Otp;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp getOtpByUser_UserNameAndOtpStatus(String userName, OtpStatus status);

    Otp getOtpByUser_UserNameAndOtpStatusAndVerifiedAndUuidAndOtp(String userName, OtpStatus status, boolean isVerified, String uuid, int Otp);


    @Modifying
    @Transactional
    @Query("update Otp o set o.otpStatus = :status where o.createdAt < :expireBeforeTime")
    void updateOtpStatusToExpired(@Param("status") OtpStatus status, @Param("expireBeforeTime") Date expireBeforeTime);

}
