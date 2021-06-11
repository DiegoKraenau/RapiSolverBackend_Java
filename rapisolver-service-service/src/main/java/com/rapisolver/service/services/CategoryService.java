package com.rapisolver.service.services;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;
import com.rapisolver.service.services.impl.CategoryServiceImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CategoryService implements CategoryServiceImpl {
    @Override
    public CategoryResponseDTO createService(CategoryRequestDTO categoryRequestDTO) throws ExecutionException {
        return null;
    }
}
