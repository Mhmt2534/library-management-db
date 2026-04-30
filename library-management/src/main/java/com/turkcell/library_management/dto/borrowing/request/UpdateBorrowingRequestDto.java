package com.turkcell.library_management.dto.borrowing.request;

import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.enums.BorrowStatus;

public class UpdateBorrowingRequestDto {
    private UUID returnedToLibrarianId;
    private Instant returnedAt;
    private BorrowStatus borrowStatus;

    public UUID getReturnedToLibrarianId() {
        return returnedToLibrarianId;
    }

    public void setReturnedToLibrarianId(UUID returnedToLibrarianId) {
        this.returnedToLibrarianId = returnedToLibrarianId;
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
