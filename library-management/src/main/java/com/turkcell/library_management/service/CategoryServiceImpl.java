package com.turkcell.library_management.service;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.request.CreateCategoryRequestDto;
import com.turkcell.library_management.entity.Category;
import com.turkcell.library_management.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void create(CreateCategoryRequestDto request){
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());

        this.categoryRepository.save(category);
    }
    

}
