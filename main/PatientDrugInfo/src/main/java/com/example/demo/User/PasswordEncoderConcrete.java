package com.example.demo.User;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderConcrete implements PasswordEncoder {


    @Override
    public String encode(CharSequence rawPassword) {
        return null;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
