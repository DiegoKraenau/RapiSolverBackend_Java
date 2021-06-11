package com.rapisolver.reservation.service.config;

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
public class ReservationServiceConfig {
    @Value("http://localhost:8089/api/v1/")
    private String userServiceUrl;

    @Value("http://localhost:8082/api/v1/")
    private String serviceServiceUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
