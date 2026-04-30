package com.turkcell.library_management.dto.borrowing.request;

import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.enums.BorrowStatus;

public class CreateBorrowingRequestDto {
    private UUID bookCopyId;
    private UUID studentId;
    private UUID borrowedByLibrarianId;

    public UUID getBookCopyId() {
        return bookCopyId;
    }

    public void setBookCopyId(UUID bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
        this.studentId = studentId;
    }

    public UUID getBorrowedByLibrarianId() {
        return borrowedByLibrarianId;
    }

    public void setBorrowedByLibrarianId(UUID borrowedByLibrarianId) {
        this.borrowedByLibrarianId = borrowedByLibrarianId;
    }

    
}
