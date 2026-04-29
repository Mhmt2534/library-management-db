package com.turkcell.library_management.dto.bookCopies.response;

import java.util.UUID;

import com.turkcell.library_management.enums.BookStatus;

public class ListBookCopyResponse {
    private UUID id;
    public UUID bookId;
    private String code;
    private BookStatus status;

    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getBookId() {
        return bookId;
    }
    public void setBookId(UUID bookId) {
        this.bookId = bookId;
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
