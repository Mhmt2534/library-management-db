package com.turkcell.library_management.service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.book.request.CreateBookRequestDto;
import com.turkcell.library_management.dto.book.request.UpdateBookRequestDto;
import com.turkcell.library_management.dto.book.response.ListBookResponse;
import com.turkcell.library_management.entity.Book;
import com.turkcell.library_management.entity.Category;
import com.turkcell.library_management.mapper.BookMapper;
import com.turkcell.library_management.repository.BookRepository;
import com.turkcell.library_management.repository.CategoryRepository;

@Service
public class BookServiceImpl {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ListBookResponse> getAll() {

        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    public ListBookResponse getById(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return BookMapper.toResponse(book);
    }

    public void create(CreateBookRequestDto request) {
        Book book = BookMapper.toEntity(request);

        Set<Category> categories = request.getCategoryIds()
                .stream()
                .map(
                        id -> categoryRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Category not found")))
                .collect(Collectors.toSet());

        book.setCategories(categories);

        bookRepository.save(book);
    }

    public void update(UUID id, UpdateBookRequestDto requestDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BookMapper.updateEntity(book, requestDto);

          Set<Category> categories = requestDto.getCategoryIds()
                .stream()
                .map(
                        categoryId -> categoryRepository.findById(categoryId)
                                .orElseThrow(() -> new RuntimeException("Category not found")))
                .collect(Collectors.toSet());

                book.setCategories(categories);
        bookRepository.save(book);
    }

    public void delete(UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        bookRepository.delete(book);
    }

}
