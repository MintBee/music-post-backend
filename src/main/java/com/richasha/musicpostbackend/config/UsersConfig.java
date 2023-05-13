package com.richasha.musicpostbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class UsersConfig {

    private final List<UserDetails> preconfiguredUsers = new ArrayList<>();

    public UsersConfig() {
        preconfigureUsers();
    }

    private void preconfigureUsers() {
        preconfiguredUsers.add(
                User.builder()
                        .username("ehddbs7458")
                        .password("7458n102")
                        .roles("ADMIN")
                        .build()
        );
    }

    @Bean
    public JdbcUserDetailsManager users(DataSource dataSource) {
        JdbcUserDetailsManager userManager = new JdbcUserDetailsManager(dataSource);
        addPreconfiguredUsers(userManager);
        return userManager;
    }

    public void addPreconfiguredUsers(UserDetailsManager userManager) {
        for (var user : preconfiguredUsers) {
            userManager.createUser(user);
        }
    }
}
