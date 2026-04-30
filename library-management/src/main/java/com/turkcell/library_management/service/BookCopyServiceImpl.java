package com.turkcell.library_management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.bookCopies.request.CreateBookCopyRequestDto;
import com.turkcell.library_management.dto.bookCopies.request.UpdateBookCopyRequestDto;
import com.turkcell.library_management.dto.bookCopies.response.ListBookCopyResponse;
import com.turkcell.library_management.entity.BookCopy;
import com.turkcell.library_management.enums.BookStatus;
import com.turkcell.library_management.mapper.BookCopyMapper;
import com.turkcell.library_management.repository.BookCopyRepository;
import com.turkcell.library_management.repository.BookRepository;

@Service
public class BookCopyServiceImpl {
    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookRepository bookRepository) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookRepository = bookRepository;
    }

      public List<ListBookCopyResponse> getAll() {

        return bookCopyRepository.findAll()
                .stream()
                .map(BookCopyMapper::toResponse)
                .toList();
    }


    public ListBookCopyResponse getById(UUID id) {
        BookCopy bookCopy = bookCopyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return BookCopyMapper.toResponse(bookCopy);
    }

    public void create(CreateBookCopyRequestDto request) {
        BookCopy bookCopy = BookCopyMapper.toEntity(request);
        
        bookCopy.setBook(
            bookRepository.findById(request.getBookId())
                .orElseThrow(()->new RuntimeException("Book not found"))
        );

        bookCopyRepository.save(bookCopy);
    }

    public void update(UUID id, UpdateBookCopyRequestDto requestDto) {
        BookCopy bookCopy = bookCopyRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Book Copy not found"));

        BookCopyMapper.updateEntity(bookCopy, requestDto);

        bookCopy.setBook(
            bookRepository.findById(requestDto.getBookId())
                .orElseThrow(()->new RuntimeException("Book not found"))
        );

        bookCopyRepository.save(bookCopy);
    }

    public void delete(UUID id) {
        BookCopy bookCopy = bookCopyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookCopyRepository.delete(bookCopy);
    }


    public void setBookStatus(BookCopy bookCopy, BookStatus status){
        bookCopy.setStatus(status);
        bookCopyRepository.save(bookCopy);
    }



}
