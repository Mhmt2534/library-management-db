package com.turkcell.library_management.mapper;

import com.turkcell.library_management.dto.request.CreateCategoryRequestDto;
import com.turkcell.library_management.dto.response.ListCategoryResponse;
import com.turkcell.library_management.entity.Category;

public class CategoryMapper {
    public static ListCategoryResponse toResponse(Category category){
        ListCategoryResponse response = new ListCategoryResponse();
        response.setCategoryName(category.getCategoryName());
        return response;
    }

    public static Category toEntity(CreateCategoryRequestDto requestDto){
        Category category = new Category();
        category.setCategoryName(requestDto.getCategoryName());
        return category;
    }

}
