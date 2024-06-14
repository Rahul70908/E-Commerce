package com.user.service;

import com.user.dto.EmailDetailsDto;
import com.user.entity.Otp;
import com.user.exception.UserServiceException;
import com.user.repo.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MailSenderService {

    private final RestClient restClient;
    private final OtpRepository otpRepository;

    @Value("${mail.send-url}")
    private String notificationUrl;

    public String send(String email, int otp) {
        LocalDateTime currentTime = LocalDateTime.now();
        Otp otpBuilder = Otp.builder().email(email).userOtp(otp)
                .createdAt(currentTime)
                .validTill(currentTime.plusMinutes(5))
                .build();
        otpRepository.save(otpBuilder);
        var emailDetails = EmailDetailsDto.builder()
                .recipient(email)
                .subject("Welcome!! Please Verify you mail.")
                .msgBody(String.format("""
                        Here is You OTP %s
                        Please Note!! This OTP is only Valid for 5 minutes.
                        """, otp))
                .build();
        var response = restClient.post().uri(notificationUrl).body(emailDetails).retrieve()
                .toEntity(String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new UserServiceException(response.getBody());
        }
    }
}
