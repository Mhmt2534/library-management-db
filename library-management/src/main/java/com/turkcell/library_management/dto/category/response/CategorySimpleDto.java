package com.turkcell.library_management.dto.category.response;

import java.util.UUID;

public class CategorySimpleDto {
  private UUID id;
    private String categoryName;


    
    public CategorySimpleDto(UUID id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
}
