package com.turkcell.library_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @PostMapping("/create")
    public void create(@RequestBody CreateCategoryRequestDto requestDto){
        categoryServiceImpl.create(requestDto);
    }

}
