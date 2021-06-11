package com.rapisolver.service.services.impl;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;

import java.util.concurrent.ExecutionException;

public interface CategoryServiceImpl {
    CategoryResponseDTO createService(CategoryRequestDTO categoryRequestDTO) throws ExecutionException;
}
