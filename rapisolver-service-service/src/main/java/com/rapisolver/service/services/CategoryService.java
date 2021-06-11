package com.rapisolver.service.services;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;
import com.rapisolver.service.entities.Category;
import com.rapisolver.service.exceptions.ServiceInternalErrorException;
import com.rapisolver.service.repositories.CategoryRepository;
import com.rapisolver.service.services.impl.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws ExecutionException {
        Category category = modelMapper.map(categoryRequestDTO,Category.class);

        try{
            category = categoryRepository.save(category);
            return modelMapper.map(category,CategoryResponseDTO.class);
        } catch (Exception e){
            throw  new ServiceInternalErrorException("CANT_CREATE_CATEGORY");
        }

    }
}
