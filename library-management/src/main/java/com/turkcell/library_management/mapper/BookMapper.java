package com.turkcell.library_management.mapper;

import com.turkcell.library_management.dto.book.request.CreateBookRequestDto;
import com.turkcell.library_management.dto.book.request.UpdateBookRequestDto;
import com.turkcell.library_management.dto.book.response.ListBookResponse;
import com.turkcell.library_management.dto.bookCopies.response.BookCopiesSimpleDto;
import com.turkcell.library_management.dto.category.response.CategorySimpleDto;
import com.turkcell.library_management.entity.Book;

public class BookMapper {

  public static ListBookResponse toResponse(Book book){
        ListBookResponse response = new ListBookResponse();
        
        response.setBookName(book.getBookName());
        response.setAuthorName(book.getAuthorName());
        response.setShelfNumber(book.getShelfNumber());
        response.setQuantityInStock(book.getQuantityInStock());

        response.setCategories(
        book.getCategories()
            .stream()
            .map(category -> new CategorySimpleDto(
                category.getId(),
                category.getCategoryName()
            ))
            .toList()
    );

    response.setBookCopies(
        book.getBookCopies()
        .stream()
        .map(
            bookCopies -> new BookCopiesSimpleDto(
                bookCopies.getCode(),
                bookCopies.getStatus()
            ))
            .toList()
    );

        return response;
    }

    public static Book toEntity(CreateBookRequestDto request) {
        Book book = new Book();
        book.setBookName(request.getBookName());
        book.setAuthorName(request.getAuthorName());
        book.setShelfNumber(request.getShelfNumber());
        book.setQuantityInStock(request.getQuantityInStock());

        return book;
    }

    public static void updateEntity(Book book, UpdateBookRequestDto request) {
        book.setBookName(request.getBookName());
        book.setAuthorName(request.getAuthorName());
        book.setShelfNumber(request.getShelfNumber());
        book.setQuantityInStock(request.getQuantityInStock());
        
    }
 
}
