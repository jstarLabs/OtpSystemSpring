package com.example.otpsystemspring.service;


import com.example.otpsystemspring.service.Impl.OtpServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OtpService.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OtpServiceTest {

    @Autowired
    private OtpServiceImpl otpServiceImpl;


}
