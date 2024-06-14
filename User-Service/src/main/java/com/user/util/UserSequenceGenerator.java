package com.user.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;
import java.security.SecureRandom;

public class UserSequenceGenerator extends SequenceStyleGenerator {

    SecureRandom secureRandom = new SecureRandom();
    public static final String SALT_CHARS = "1234567890";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return Long.parseLong(randomNumber(4));
    }

    private String randomNumber(int digit) {
        var stringBuilder = new StringBuilder();
        while (stringBuilder.length() < digit) {
            int index = secureRandom.nextInt(40000) * SALT_CHARS.length();
            stringBuilder.append(index);
        }
        return stringBuilder.toString();
    }
}
