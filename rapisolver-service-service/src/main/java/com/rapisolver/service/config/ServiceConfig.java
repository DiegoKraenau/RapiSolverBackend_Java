package com.rapisolver.service.config;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Getter
@Configuration
@PropertySource({"classpath:application.properties"})
public class ServiceConfig {

    @Value("${userservice.url}")
    private String userServiceUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
