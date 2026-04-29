package com.turkcell.library_management.mapper;

import com.turkcell.library_management.dto.bookCopies.request.CreateBookCopyRequestDto;
import com.turkcell.library_management.dto.bookCopies.request.UpdateBookCopyRequestDto;
import com.turkcell.library_management.dto.bookCopies.response.ListBookCopyResponse;
import com.turkcell.library_management.dto.category.request.CreateCategoryRequestDto;
import com.turkcell.library_management.dto.category.request.UpdateCategoryRequestDto;
import com.turkcell.library_management.dto.category.response.ListCategoryResponse;
import com.turkcell.library_management.entity.BookCopy;

public class BookCopyMapper {

     public static ListBookCopyResponse toResponse(BookCopy bookCopy){
        ListBookCopyResponse response = new ListBookCopyResponse();
        
        response.setId(bookCopy.getId());
        response.setBookId(bookCopy.getBook().getId());
        response.setCode(bookCopy.getCode());
        response.setStatus(bookCopy.getStatus());

        return response;
    }

    public static BookCopy toEntity(CreateBookCopyRequestDto requestDto){
        BookCopy bookCopy = new BookCopy();

        bookCopy.setCode(requestDto.getCode());
        bookCopy.setStatus(requestDto.getStatus());

        return bookCopy;
    }

    
    public static void updateEntity(BookCopy bookCopy, UpdateBookCopyRequestDto request) {
        bookCopy.setCode(request.getCode());
        bookCopy.setStatus(request.getStatus());
    }   


}
