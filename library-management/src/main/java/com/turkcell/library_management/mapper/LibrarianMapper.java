package com.turkcell.library_management.mapper;

import java.util.List;

import com.turkcell.library_management.dto.borrowing.response.BorrowingSimpleDto;
import com.turkcell.library_management.dto.librarian.request.CreateLibrarianRequestDto;
import com.turkcell.library_management.dto.librarian.request.UpdateLibrarianRequestDto;
import com.turkcell.library_management.dto.librarian.response.ListLibrarianResponse;
import com.turkcell.library_management.entity.Librarian;

public class LibrarianMapper {

    public static ListLibrarianResponse toResponse(Librarian librarian) {
        ListLibrarianResponse response = new ListLibrarianResponse();

        response.setId(librarian.getId());
        response.setIdentityNumber(librarian.getIdentityNumber());
        response.setLibrarianName(librarian.getLibrarianName());
        response.setLibrarianSurname(librarian.getLibrarianSurname());
        response.setPhoneNumber(librarian.getPhoneNumber());
        response.setShift(librarian.getShift());

        response.setBorrowingsGiven(
            librarian.getBorrowingsGiven() == null ? List.of() : librarian.getBorrowingsGiven()
                .stream()
                .map(borrowing -> new BorrowingSimpleDto(
                    borrowing.getId(),
                    borrowing.getBorrowedAt(),
                    borrowing.getDueAt(),
                    borrowing.getReturnedAt(),
                    borrowing.getBorrowStatus()
                ))
                .toList()
        );

        response.setBorrowingsReceived(
            librarian.getBorrowingsReceived() == null ? List.of() : librarian.getBorrowingsReceived()
                .stream()
                .map(borrowing -> new BorrowingSimpleDto(
                    borrowing.getId(),
                    borrowing.getBorrowedAt(),
                    borrowing.getDueAt(),
                    borrowing.getReturnedAt(),
                    borrowing.getBorrowStatus()
                ))
                .toList()
        );

        return response;
    }

    public static Librarian toEntity(CreateLibrarianRequestDto request) {
        Librarian librarian = new Librarian();
        librarian.setIdentityNumber(request.getIdentityNumber());
        librarian.setLibrarianName(request.getLibrarianName());
        librarian.setLibrarianSurname(request.getLibrarianSurname());
        librarian.setPhoneNumber(request.getPhoneNumber());
        librarian.setShift(request.getShift());
        return librarian;
    }

    public static void updateEntity(Librarian librarian, UpdateLibrarianRequestDto request) {
        librarian.setIdentityNumber(request.getIdentityNumber());
        librarian.setLibrarianName(request.getLibrarianName());
        librarian.setLibrarianSurname(request.getLibrarianSurname());
        librarian.setPhoneNumber(request.getPhoneNumber());
        librarian.setShift(request.getShift());
    }
}
