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
import com.turkcell.library_management.dto.bookCopies.request.CreateBookCopyRequestDto;
import com.turkcell.library_management.dto.bookCopies.request.UpdateBookCopyRequestDto;
import com.turkcell.library_management.dto.bookCopies.response.ListBookCopyResponse;
import com.turkcell.library_management.service.BookCopyServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/bookCopy")
public class BookCopyController {

    private  final BookCopyServiceImpl bookCopyService;

    public BookCopyController(BookCopyServiceImpl bookCopyService) {
        this.bookCopyService = bookCopyService;
    }
    
    @GetMapping("/getAll")
    public List<ListBookCopyResponse> getAll(){
        return bookCopyService.getAll();
    }

    @GetMapping("/get/{id}")
    public ListBookCopyResponse getMethodName(@PathVariable UUID id) {
        return bookCopyService.getById(id);
    }
    

    @PostMapping("/create")
    public void create(@RequestBody CreateBookCopyRequestDto requestDto) {
        bookCopyService.create(requestDto);
    }

    //Best practice than just RequestBody
    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                        @RequestBody UpdateBookCopyRequestDto request) {
        bookCopyService.update(id,request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        bookCopyService.delete(id);
    }
    


}
