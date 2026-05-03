package com.turkcell.library_management.dto.penalty.request;

import java.math.BigDecimal;
import java.util.UUID;

import com.turkcell.library_management.enums.PaymentStatus;

public class CreatePenaltyRequestDto {
    private UUID borrowingId;
    private BigDecimal amountTry;
    private String description;

    public UUID getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(UUID borrowingId) {
        this.borrowingId = borrowingId;
    }

    public BigDecimal getAmountTry() {
        return amountTry;
    }

    public void setAmountTry(BigDecimal amountTry) {
        this.amountTry = amountTry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
