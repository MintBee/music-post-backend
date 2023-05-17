package com.richasha.musicpostbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
// TODO: 2023-05-17 Solve problem that no one can access to app because of auth problem by this
//    @Bean
//    public BCryptPasswordEncoder generatePasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean RawPasswordSender rawPasswordSender() {
        return new RawPasswordSender();
    }

    private static class RawPasswordSender implements PasswordEncoder {

        @Override
        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }

        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            return rawPassword.toString().equals(encodedPassword);
        }
    }

}

