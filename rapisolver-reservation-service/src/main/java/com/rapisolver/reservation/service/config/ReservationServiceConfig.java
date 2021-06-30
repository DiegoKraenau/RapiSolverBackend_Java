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
    @Value("http://localhost:8090/api/v1/user")
    private String userServiceUrl;

    @Value("http://localhost:8089/api/v1/users-services")
    private String serviceServiceUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
