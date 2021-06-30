package com.rapisolver.service.services;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;

import java.util.List;


public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws RuntimeException;
    List<CategoryResponseDTO> getAllCategories() throws  RuntimeException;
}
