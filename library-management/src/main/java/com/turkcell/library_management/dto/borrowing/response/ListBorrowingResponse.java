package com.turkcell.library_management.dto.borrowing.response;

import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.dto.bookCopies.response.BookCopiesSimpleDto;
import com.turkcell.library_management.dto.penalty.response.PenaltySimpleDto;
import com.turkcell.library_management.enums.BorrowStatus;

public class ListBorrowingResponse {
    private UUID id;
    private BookCopiesSimpleDto bookCopy;
    private UUID studentId;
    private UUID borrowedByLibrarianId;
    private UUID returnedToLibrarianId;
    private Instant borrowedAt;
    private Instant dueAt;
    private Instant returnedAt;
    private BorrowStatus borrowStatus;
    private PenaltySimpleDto penalty;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BookCopiesSimpleDto getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopiesSimpleDto bookCopy) {
        this.bookCopy = bookCopy;
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

    public UUID getReturnedToLibrarianId() {
        return returnedToLibrarianId;
    }

    public void setReturnedToLibrarianId(UUID returnedToLibrarianId) {
        this.returnedToLibrarianId = returnedToLibrarianId;
    }

    public Instant getBorrowedAt() {
        return borrowedAt;
    }

    public void setBorrowedAt(Instant borrowedAt) {
        this.borrowedAt = borrowedAt;
    }

    public Instant getDueAt() {
        return dueAt;
    }

    public void setDueAt(Instant dueAt) {
        this.dueAt = dueAt;
    }

    public Instant getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Instant returnedAt) {
        this.returnedAt = returnedAt;
    }

    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public PenaltySimpleDto getPenalty() {
        return penalty;
    }

    public void setPenalty(PenaltySimpleDto penalty) {
        this.penalty = penalty;
    }
}
