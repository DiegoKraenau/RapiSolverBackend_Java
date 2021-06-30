package com.rapisolver.service.controllers;

import com.rapisolver.service.dtos.CategoryRequestDTO;
import com.rapisolver.service.dtos.CategoryResponseDTO;
import com.rapisolver.service.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "category")
    public ResponseEntity<CategoryResponseDTO> createAccount(@RequestBody CategoryRequestDTO category) throws RuntimeException {
        CategoryResponseDTO categoryResponse = categoryService.createCategory(category);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "category")
    public ResponseEntity<List<CategoryResponseDTO>> getCategories() throws RuntimeException {
        List<CategoryResponseDTO> listCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(listCategories, HttpStatus.CREATED);
    }

}
