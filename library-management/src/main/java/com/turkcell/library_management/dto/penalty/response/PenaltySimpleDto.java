package com.turkcell.library_management.dto.penalty.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.enums.PaymentStatus;

public class PenaltySimpleDto {
    private UUID id;
    private BigDecimal amountTry;
    private Instant penaltyDate;
    private Instant paidAt;
    private PaymentStatus paymentStatus;
    private String description;

    public PenaltySimpleDto(UUID id, BigDecimal amountTry, Instant penaltyDate, Instant paidAt, PaymentStatus paymentStatus, String description) {
        this.id = id;
        this.amountTry = amountTry;
        this.penaltyDate = penaltyDate;
        this.paidAt = paidAt;
        this.paymentStatus = paymentStatus;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
