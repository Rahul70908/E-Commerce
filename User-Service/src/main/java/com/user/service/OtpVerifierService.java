package com.user.service;

import com.user.dto.OtpVerifierDto;
import com.user.entity.Otp;
import com.user.exception.UserServiceException;
import com.user.repo.OtpRepository;
import com.user.repo.UserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OtpVerifierService {

    private final OtpRepository otpRepository;
    private final UserDetailsRepository userDetailsRepository;

    public String verifyOtp(OtpVerifierDto verifierDto) {
        Otp otp = otpRepository.findByUserOtpAndEmail(verifierDto.getOtp(), verifierDto.getEmail())
                .orElseThrow(() ->
                        new UserServiceException("Otp Not Found for user" + verifierDto.getEmail()));
        if (otp.getValidTill().isAfter(LocalDateTime.now())) {
            userDetailsRepository.updateUserStatus("Y", otp.getEmail());
            return "User Verification Successful";
        } else {
            return "OTP Expired!! Please Send it Again";
        }
    }
}
