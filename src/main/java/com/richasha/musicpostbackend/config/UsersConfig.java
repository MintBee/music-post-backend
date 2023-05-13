package com.richasha.musicpostbackend.config;

import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class UsersConfig {
    private static final List<UserEntity> preparedUserEntities = List.of(
            new UserEntity("ehddbs7458", "7458n102"),
            new UserEntity("timmy", "timmy")
    );

    private static final List<UserDetails> preconfiguredUsers = preparedUserEntities
            .stream()
            .map((userEntity -> new MyUserDetails(userEntity.getUsername(), userEntity.getPassword())))
            .collect(Collectors.toList());

    @Autowired
    public void addPreconfiguredUsers(UserDetailsManager userManager) {
        for (var user : preconfiguredUsers) {
            userManager.createUser(user);
        }
    }
}
