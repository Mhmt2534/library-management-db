package com.turkcell.library_management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.category.request.CreateCategoryRequestDto;
import com.turkcell.library_management.dto.category.request.UpdateCategoryRequestDto;
import com.turkcell.library_management.dto.category.response.ListCategoryResponse;
import com.turkcell.library_management.entity.Category;
import com.turkcell.library_management.mapper.CategoryMapper;
import com.turkcell.library_management.repository.CategoryRepository;

@Service
public class CategoryServiceImpl {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<ListCategoryResponse> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    public ListCategoryResponse getById(UUID id){
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));

            return CategoryMapper.toResponse(category);
    }

    public void create(CreateCategoryRequestDto request) {
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());

        this.categoryRepository.save(category);
    }

    public void update(UUID id,UpdateCategoryRequestDto requestDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        CategoryMapper.updateEntity(category, requestDto);

        categoryRepository.save(category);
    }

    public void delete(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepository.delete(category);
    }

}
