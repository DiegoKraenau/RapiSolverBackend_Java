package com.rapisolver.service.client;

import com.rapisolver.service.config.ServiceConfig;
import com.rapisolver.service.dtos.SupplierDTO;
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
public class UserClient {

    private RestTemplate restTemplate;

    @Autowired
    private ServiceConfig config;

    public UserClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Optional<SupplierDTO> findSupplier(Long id){
        Optional<SupplierDTO> result = Optional.empty();
        try {
            result = Optional.ofNullable(restTemplate.getForObject(config.getUserServiceUrl()+"/{id}",SupplierDTO.class,id));
        }catch (HttpClientErrorException ex){
            if(ex.getStatusCode() != HttpStatus.NOT_FOUND){
                throw ex;
            }
        }
        return result;
    }

    /*private RestTemplate restTemplate;

    @Autowired
    private ServiceConfig config;

    public UserClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Optional<>*/
}
