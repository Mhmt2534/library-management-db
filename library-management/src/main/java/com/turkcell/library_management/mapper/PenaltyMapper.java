package com.turkcell.library_management.mapper;

import com.turkcell.library_management.dto.borrowing.response.BorrowingSimpleDto;
import com.turkcell.library_management.dto.penalty.request.CreatePenaltyRequestDto;
import com.turkcell.library_management.dto.penalty.request.UpdatePenaltyRequestDto;
import com.turkcell.library_management.dto.penalty.response.ListPenaltyResponse;
import com.turkcell.library_management.entity.Penalty;
import com.turkcell.library_management.enums.PaymentStatus;

import java.time.Instant;

public class PenaltyMapper {

    public static ListPenaltyResponse toResponse(Penalty penalty) {
        ListPenaltyResponse response = new ListPenaltyResponse();

        response.setId(penalty.getId());

        if (penalty.getBorrowing() != null) {
            response.setBorrowing(new BorrowingSimpleDto(
                penalty.getBorrowing().getId(),
                penalty.getBorrowing().getBorrowedAt(),
                penalty.getBorrowing().getDueAt(),
                penalty.getBorrowing().getReturnedAt(),
                penalty.getBorrowing().getBorrowStatus()
            ));
        }

        response.setAmountTry(penalty.getAmountTry());
        response.setPenaltyDate(penalty.getPenaltyDate());
        response.setPaidAt(penalty.getPaidAt());
        response.setPaymentStatus(penalty.getPaymentStatus());
        response.setDescription(penalty.getDescription());

        return response;
    }

    public static Penalty toEntity(CreatePenaltyRequestDto request) {
        Penalty penalty = new Penalty();
        penalty.setAmountTry(request.getAmountTry());
        penalty.setPenaltyDate(Instant.now());
        penalty.setPaymentStatus(PaymentStatus.PENDING);
        penalty.setDescription(request.getDescription());
        return penalty;
    }

    public static void updateEntity(Penalty penalty, UpdatePenaltyRequestDto request) {
        if (request.getAmountTry() != null) {
            penalty.setAmountTry(request.getAmountTry());
        }
        if (request.getPaidAt() != null) {
            penalty.setPaidAt(request.getPaidAt());
        }
        if (request.getPaymentStatus() != null) {
            penalty.setPaymentStatus(request.getPaymentStatus());
        }
        if (request.getDescription() != null) {
            penalty.setDescription(request.getDescription());
        }
    }
}
