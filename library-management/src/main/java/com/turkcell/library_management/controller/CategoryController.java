package com.turkcell.library_management.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_management.dto.request.CreateCategoryRequestDto;
import com.turkcell.library_management.dto.request.UpdateCategoryRequestDto;
import com.turkcell.library_management.dto.response.CategoryResponse;
import com.turkcell.library_management.dto.response.ListCategoryResponse;
import com.turkcell.library_management.entity.Category;
import com.turkcell.library_management.service.CategoryServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/getAll")
    public List<ListCategoryResponse> getMethodName() {
        return categoryServiceImpl.getAll();
    }

    @GetMapping("/get/{id}")
    public ListCategoryResponse getMethodName(@PathVariable UUID id) {
        return categoryServiceImpl.getById(id);
    }
    

    @PostMapping("/create")
    public void create(@RequestBody CreateCategoryRequestDto requestDto) {
        categoryServiceImpl.create(requestDto);
    }

    //Best practice than just RequestBody
    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                        @RequestBody UpdateCategoryRequestDto request) {
        categoryServiceImpl.update(id,request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        categoryServiceImpl.delete(id);
    }

}
