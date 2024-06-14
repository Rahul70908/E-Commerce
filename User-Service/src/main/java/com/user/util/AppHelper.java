package com.user.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppHelper {

    public static int generateOtp() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        return Integer.parseInt(String.format("%05d", num));
    }
}
