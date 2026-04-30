package com.turkcell.library_management.dto.librarian.response;

import java.util.List;
import java.util.UUID;

import com.turkcell.library_management.dto.borrowing.response.BorrowingSimpleDto;
import com.turkcell.library_management.enums.Shift;

public class ListLibrarianResponse {
    private UUID id;
    private String identityNumber;
    private String librarianName;
    private String librarianSurname;
    private String phoneNumber;
    private Shift shift;
    private List<BorrowingSimpleDto> borrowingsGiven;
    private List<BorrowingSimpleDto> borrowingsReceived;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getLibrarianSurname() {
        return librarianSurname;
    }

    public void setLibrarianSurname(String librarianSurname) {
        this.librarianSurname = librarianSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public List<BorrowingSimpleDto> getBorrowingsGiven() {
        return borrowingsGiven;
    }

    public void setBorrowingsGiven(List<BorrowingSimpleDto> borrowingsGiven) {
        this.borrowingsGiven = borrowingsGiven;
    }

    public List<BorrowingSimpleDto> getBorrowingsReceived() {
        return borrowingsReceived;
    }

    public void setBorrowingsReceived(List<BorrowingSimpleDto> borrowingsReceived) {
        this.borrowingsReceived = borrowingsReceived;
    }
}
