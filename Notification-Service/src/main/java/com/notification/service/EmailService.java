package com.notification.service;

import com.notification.dto.EmailDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    public String sendMail(EmailDetailsDto detailsDto) {
        try {
            var simpleMessage = new SimpleMailMessage();
            simpleMessage.setFrom(senderMail);
            simpleMessage.setTo(detailsDto.getRecipient());
            simpleMessage.setSubject(detailsDto.getSubject());
            simpleMessage.setText(detailsDto.getMsgBody());
            mailSender.send(simpleMessage);
            return "Email Sent Successfully";
        } catch (Exception e) {
            log.error("Error in Sending Mail");
            return "Error in Sending Mail";
        }
    }
}
