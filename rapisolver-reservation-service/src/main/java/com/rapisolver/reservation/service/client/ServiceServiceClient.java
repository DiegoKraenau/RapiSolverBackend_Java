package com.rapisolver.reservation.service.client;

import com.rapisolver.reservation.service.config.ReservationServiceConfig;
import com.rapisolver.reservation.service.dtos.SupplierAttentionDTO;
import com.rapisolver.reservation.service.dtos.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Component
public class ServiceServiceClient {
    private RestTemplate restTemplate;

    @Autowired
    private ReservationServiceConfig config;

    public ServiceServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Optional<SupplierAttentionDTO> findSupplierAttentionById(Long supplierAttentionId) {
        Optional<SupplierAttentionDTO> result = Optional.empty();
        try {
            result = Optional.ofNullable(restTemplate.getForObject(config.getServiceServiceUrl() + "SupplierAttention" + "/{id}", SupplierAttentionDTO.class, supplierAttentionId));
        }
        catch (HttpClientErrorException ex)   {
            if (ex.getStatusCode() != HttpStatus.NOT_FOUND) {
                throw ex;
            }
        }
        return result;
    }
}
