package com.turkcell.library_management.dto.category.request;

import java.util.UUID;

public class UpdateCategoryRequestDto {
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
   
    
}
