package com.turkcell.library_management.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_management.dto.book.request.CreateBookRequestDto;
import com.turkcell.library_management.dto.book.request.UpdateBookRequestDto;
import com.turkcell.library_management.dto.book.response.ListBookResponse;
import com.turkcell.library_management.service.BookServiceImpl;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/getAll")
    public List<ListBookResponse> getMethodName() {
        return bookService.getAll();
    }

    @GetMapping("/get/{id}")
    public ListBookResponse getMethodName(@PathVariable UUID id) {
        return bookService.getById(id);
    }
    

    @PostMapping("/create")
    public void create(@RequestBody CreateBookRequestDto requestDto) {
        bookService.create(requestDto);
    }

    //Best practice than just RequestBody
    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                        @RequestBody UpdateBookRequestDto request) {
        bookService.update(id,request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        bookService.delete(id);
    }

    
}
