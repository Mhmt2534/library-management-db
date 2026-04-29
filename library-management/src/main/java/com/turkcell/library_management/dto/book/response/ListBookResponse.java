package com.turkcell.library_management.dto.book.response;

import java.util.List;
import java.util.Set;

import com.turkcell.library_management.dto.bookCopies.response.BookCopiesSimpleDto;
import com.turkcell.library_management.dto.category.response.CategorySimpleDto;
import com.turkcell.library_management.entity.BookCopy;
import com.turkcell.library_management.entity.Category;

public class ListBookResponse {
    private String bookName;
    private String authorName;
    private String shelfNumber;
    private int quantityInStock;
    private List<CategorySimpleDto> categories;
    private List<BookCopiesSimpleDto> bookCopies;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public List<CategorySimpleDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorySimpleDto> categories) {
        this.categories = categories;
    }

    public List<BookCopiesSimpleDto> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopiesSimpleDto> bookCopies) {
        this.bookCopies = bookCopies;
    }


}
