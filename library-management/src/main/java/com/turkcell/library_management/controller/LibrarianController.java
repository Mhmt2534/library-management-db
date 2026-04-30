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

import com.turkcell.library_management.dto.librarian.request.CreateLibrarianRequestDto;
import com.turkcell.library_management.dto.librarian.request.UpdateLibrarianRequestDto;
import com.turkcell.library_management.dto.librarian.response.ListLibrarianResponse;
import com.turkcell.library_management.service.LibrarianServiceImpl;

@RestController
@RequestMapping("/api/librarians")
public class LibrarianController {
    private final LibrarianServiceImpl librarianService;

    public LibrarianController(LibrarianServiceImpl librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping("/getAll")
    public List<ListLibrarianResponse> getAll() {
        return librarianService.getAll();
    }

    @GetMapping("/get/{id}")
    public ListLibrarianResponse getById(@PathVariable UUID id) {
        return librarianService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody CreateLibrarianRequestDto requestDto) {
        librarianService.create(requestDto);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable UUID id,
                       @RequestBody UpdateLibrarianRequestDto request) {
        librarianService.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        librarianService.delete(id);
    }
}
