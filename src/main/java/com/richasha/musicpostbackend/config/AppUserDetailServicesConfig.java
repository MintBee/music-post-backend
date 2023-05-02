package com.richasha.musicpostbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

public class AppUserDetailServicesConfig {
    private final static String DB_NAME = "";

    @Bean
    public UserDetailsService userDetailsService() {
        return new JdbcUserDetailsManager(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/" + DB_NAME);
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        return dataSource;
    }
}
