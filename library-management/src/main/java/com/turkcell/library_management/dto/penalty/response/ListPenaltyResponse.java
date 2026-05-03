package com.turkcell.library_management.dto.penalty.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.dto.borrowing.response.BorrowingSimpleDto;
import com.turkcell.library_management.enums.PaymentStatus;

public class ListPenaltyResponse {
    private UUID id;
    private BorrowingSimpleDto borrowing;
    private BigDecimal amountTry;
    private Instant penaltyDate;
    private Instant paidAt;
    private PaymentStatus paymentStatus;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BorrowingSimpleDto getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(BorrowingSimpleDto borrowing) {
        this.borrowing = borrowing;
    }

    public BigDecimal getAmountTry() {
        return amountTry;
    }

    public void setAmountTry(BigDecimal amountTry) {
        this.amountTry = amountTry;
    }

    public Instant getPenaltyDate() {
        return penaltyDate;
    }

    public void setPenaltyDate(Instant penaltyDate) {
        this.penaltyDate = penaltyDate;
    }

    public Instant getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Instant paidAt) {
        this.paidAt = paidAt;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
