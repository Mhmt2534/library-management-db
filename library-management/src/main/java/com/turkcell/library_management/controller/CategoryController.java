package com.turkcell.library_management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_management.dto.request.CreateCategoryRequestDto;
import com.turkcell.library_management.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }
    

    public void create(CreateCategoryRequestDto requestDto){
        categoryServiceImpl.create(requestDto);
    }

}
