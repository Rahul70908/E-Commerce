package com.notification.controller;

import com.notification.dto.EmailDetailsDto;
import com.notification.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping(path = "/send")
    public ResponseEntity<String> sendEmail(@Valid @RequestBody EmailDetailsDto detailsDto) {
        return ResponseEntity.ok(emailService.sendMail(detailsDto));
    }
}
