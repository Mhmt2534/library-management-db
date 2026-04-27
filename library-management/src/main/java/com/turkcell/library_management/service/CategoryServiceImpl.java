package com.turkcell.library_management.service;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    

}
