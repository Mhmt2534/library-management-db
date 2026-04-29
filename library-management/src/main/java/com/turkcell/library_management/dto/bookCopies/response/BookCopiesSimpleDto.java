package com.turkcell.library_management.dto.bookCopies.response;

import com.turkcell.library_management.enums.BookStatus;

public class BookCopiesSimpleDto {
    private String code;
    private BookStatus status;


    
    public BookCopiesSimpleDto(String code, BookStatus status) {
        this.code = code;
        this.status = status;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public BookStatus getStatus() {
        return status;
    }
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    
}
