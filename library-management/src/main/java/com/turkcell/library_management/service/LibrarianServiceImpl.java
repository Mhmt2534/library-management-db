package com.turkcell.library_management.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_management.dto.librarian.request.CreateLibrarianRequestDto;
import com.turkcell.library_management.dto.librarian.request.UpdateLibrarianRequestDto;
import com.turkcell.library_management.dto.librarian.response.ListLibrarianResponse;
import com.turkcell.library_management.entity.Librarian;
import com.turkcell.library_management.mapper.LibrarianMapper;
import com.turkcell.library_management.repository.LibrarianRepository;

@Service
public class LibrarianServiceImpl {
    private final LibrarianRepository librarianRepository;

    public LibrarianServiceImpl(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    public List<ListLibrarianResponse> getAll() {
        return librarianRepository.findAll()
                .stream()
                .map(LibrarianMapper::toResponse)
                .toList();
    }

    public ListLibrarianResponse getById(UUID id) {
        Librarian librarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found"));

        return LibrarianMapper.toResponse(librarian);
    }

    public void create(CreateLibrarianRequestDto request) {
        if (librarianRepository.existsByIdentityNumber(request.getIdentityNumber())) {
            throw new RuntimeException("Identity number already exists");
        }

        if (librarianRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists");
        }

        Librarian librarian = LibrarianMapper.toEntity(request);
        librarianRepository.save(librarian);
    }

    public void update(UUID id, UpdateLibrarianRequestDto request) {
        Librarian librarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found"));

                /* 
        if (!librarian.getIdentityNumber().equals(request.getIdentityNumber())
                && librarianRepository.existsByIdentityNumber(request.getIdentityNumber())) {
            throw new RuntimeException("Identity number already exists");
        }

        if (!librarian.getPhoneNumber().equals(request.getPhoneNumber())
                && librarianRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new RuntimeException("Phone number already exists");
        }
*/
        LibrarianMapper.updateEntity(librarian, request);
        librarianRepository.save(librarian);
    }

    public void delete(UUID id) {
        Librarian librarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Librarian not found"));

        librarianRepository.delete(librarian);
    }
}
