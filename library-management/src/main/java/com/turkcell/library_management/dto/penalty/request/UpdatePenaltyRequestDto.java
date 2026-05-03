package com.turkcell.library_management.dto.penalty.request;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import com.turkcell.library_management.enums.PaymentStatus;

public class UpdatePenaltyRequestDto {
    private BigDecimal amountTry;
    private Instant paidAt;
    private PaymentStatus paymentStatus;
    private String description;

    public BigDecimal getAmountTry() {
        return amountTry;
    }

    public void setAmountTry(BigDecimal amountTry) {
        this.amountTry = amountTry;
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
