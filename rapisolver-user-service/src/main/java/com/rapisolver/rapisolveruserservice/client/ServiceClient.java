package com.rapisolver.rapisolveruserservice.client;

import com.rapisolver.rapisolveruserservice.config.ServiceConfig;
import com.rapisolver.rapisolveruserservice.dtos.ListUserRapiServiceClientDTO;
import com.rapisolver.rapisolveruserservice.dtos.SupplierServiceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ServiceClient {

    private RestTemplate restTemplate;

    @Autowired
    private ServiceConfig config;

    public ServiceClient(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public Optional<ListUserRapiServiceClientDTO> getSupplierServices(Long id){
        Optional<ListUserRapiServiceClientDTO> result = Optional.empty();
        try {
            result = Optional.ofNullable(restTemplate.getForObject(config.getServiceClientUrl()+"/{id}", ListUserRapiServiceClientDTO.class,id));
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