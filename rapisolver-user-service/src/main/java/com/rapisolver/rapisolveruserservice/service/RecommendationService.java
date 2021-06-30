package com.rapisolver.rapisolveruserservice.service;

import com.rapisolver.rapisolveruserservice.dtos.ListRecomendationDTO;
import org.springframework.stereotype.Service;

@Service
public interface RecommendationService {

    ListRecomendationDTO getRecommedationBySupplier(Long supplierId);

}
