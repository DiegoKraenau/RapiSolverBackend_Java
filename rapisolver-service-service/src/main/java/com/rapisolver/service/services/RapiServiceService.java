package com.rapisolver.service.services;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;
import com.rapisolver.service.dtos.ServiceRequestDTO;
import com.rapisolver.service.dtos.ServiceResponseDTO;

import java.util.concurrent.ExecutionException;

public interface RapiServiceService {
    ServiceResponseDTO createService(ServiceRequestDTO serviceRequestDTO) throws RuntimeException;
}
