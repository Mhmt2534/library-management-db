package com.turkcell.library_management.mapper;

import com.turkcell.library_management.dto.bookCopies.response.BookCopiesSimpleDto;
import com.turkcell.library_management.dto.borrowing.request.CreateBorrowingRequestDto;
import com.turkcell.library_management.dto.borrowing.request.UpdateBorrowingRequestDto;
import com.turkcell.library_management.dto.borrowing.response.ListBorrowingResponse;
import com.turkcell.library_management.dto.penalty.response.PenaltySimpleDto;
import com.turkcell.library_management.entity.Borrowing;

public class BorrowingMapper {

    public static ListBorrowingResponse toResponse(Borrowing borrowing) {
        ListBorrowingResponse response = new ListBorrowingResponse();

        response.setId(borrowing.getId());
        
        if (borrowing.getBookCopy() != null) {
            response.setBookCopy(new BookCopiesSimpleDto(
                borrowing.getBookCopy().getCode(),
                borrowing.getBookCopy().getStatus()
            ));
        }

        if (borrowing.getStudent() != null) {
            response.setStudentId(borrowing.getStudent().getId());
        }

        if (borrowing.getBorrowedByLibrarian() != null) {
            response.setBorrowedByLibrarianId(borrowing.getBorrowedByLibrarian().getId());
        }

        if (borrowing.getReturnedToLibrarian() != null) {
            response.setReturnedToLibrarianId(borrowing.getReturnedToLibrarian().getId());
        }

        response.setBorrowedAt(borrowing.getBorrowedAt());
        response.setDueAt(borrowing.getDueAt());
        response.setReturnedAt(borrowing.getReturnedAt());
        response.setBorrowStatus(borrowing.getBorrowStatus());

        if (borrowing.getPenalty() != null) {
            response.setPenalty(new PenaltySimpleDto(
                borrowing.getPenalty().getId(),
                borrowing.getPenalty().getAmountTry(),
                borrowing.getPenalty().getPenaltyDate(),
                borrowing.getPenalty().getPaidAt(),
                borrowing.getPenalty().getPaymentStatus(),
                borrowing.getPenalty().getDescription()
            ));
        }

        return response;
    }
}
