package com.turkcell.library_management.dto.borrowing.response;

import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.enums.BorrowStatus;

public class BorrowingSimpleDto {
    private UUID id;
    private Instant borrowedAt;
    private Instant dueAt;
    private Instant returnedAt;
    private BorrowStatus borrowStatus;

    public BorrowingSimpleDto(UUID id, Instant borrowedAt, Instant dueAt, Instant returnedAt, BorrowStatus borrowStatus) {
        this.id = id;
        this.borrowedAt = borrowedAt;
        this.dueAt = dueAt;
        this.returnedAt = returnedAt;
        this.borrowStatus = borrowStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}