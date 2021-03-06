package com.rapisolver.service.services.impl;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;
import com.rapisolver.service.entities.Category;
import com.rapisolver.service.exceptions.ServiceInternalErrorException;
import com.rapisolver.service.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class CategoryServiceImpl implements com.rapisolver.service.services.CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) throws RuntimeException {
        Category category = modelMapper.map(categoryRequestDTO,Category.class);

        try{
            category = categoryRepository.save(category);
            return modelMapper.map(category,CategoryResponseDTO.class);
        } catch (Exception e){
            throw  new ServiceInternalErrorException("CANT_CREATE_CATEGORY");
        }

    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() throws RuntimeException {
        try{
            List<Category> categoriesList = categoryRepository.findAll();
            List<CategoryResponseDTO> responseList = new ArrayList<CategoryResponseDTO>();
            for (Category category:categoriesList){
                CategoryResponseDTO c = modelMapper.map(category,CategoryResponseDTO.class);
                responseList.add(c);
            }
            return responseList;
        } catch (Exception e){
            throw  new ServiceInternalErrorException("NOT_FOUND_CATEGORIES");
        }

    }
}
