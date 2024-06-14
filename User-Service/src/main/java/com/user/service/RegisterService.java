package com.user.service;

import com.user.dto.UserRegisterDto;
import com.user.entity.User;
import com.user.exception.UserServiceException;
import com.user.repo.UserDetailsRepository;
import com.user.util.AppHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final UserDetailsRepository userDetailsRepository;
    private final MailSenderService senderService;

    public void registerUser(UserRegisterDto registerDto) {
        if (userDetailsRepository.existsByEmail(registerDto.getEmail())) {
            throw new UserServiceException("User Already Exists!!");
        } else {
            senderService.send(registerDto.getEmail(), AppHelper.generateOtp());
            userDetailsRepository.save(User.builder()
                    .email(registerDto.getEmail())
                    .activeStatus("N")
                    .build());
        }
    }
}
