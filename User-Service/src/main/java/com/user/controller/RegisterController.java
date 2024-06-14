package com.user.controller;

import com.user.dto.OtpVerifierDto;
import com.user.dto.UserRegisterDto;
import com.user.service.OtpVerifierService;
import com.user.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;
    private final OtpVerifierService verifierService;

    @PostMapping("/new")
    public ResponseEntity<UserRegisterDto> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto) {
        registerService.registerUser(userRegisterDto);
        return ResponseEntity.ok(userRegisterDto);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpVerifierDto verifierDto) {
        return ResponseEntity.ok(verifierService.verifyOtp(verifierDto));
    }
}
