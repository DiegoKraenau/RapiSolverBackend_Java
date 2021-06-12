package com.rapisolver.rapisolveruserservice.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
//@PropertySource({"classpath:application.properties"})
public class UserServiceConfig {
/*
    @Value("${customerservice.url}")
    private String customerServiceUrl;

    @Value("${paymentservice.url}")
    private String paymentServiceUrl;
*/
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}