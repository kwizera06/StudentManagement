package com.example.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender mail;

    public void sendOtp(String toEmail , String otp){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Email Verification Code");
        simpleMailMessage.setText("your OTP verification code is "+ otp + "\n it will be long last for 10 minutes");

        mail.send(simpleMailMessage);
    }
}
