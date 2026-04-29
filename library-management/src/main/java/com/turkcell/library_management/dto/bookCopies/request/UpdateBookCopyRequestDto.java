package com.turkcell.library_management.dto.bookCopies.request;

import java.util.UUID;

import com.turkcell.library_management.enums.BookStatus;

public class UpdateBookCopyRequestDto {
private String code;

private BookStatus status;

private UUID bookId;

public String getCode() {
    return code;
}

public void setCode(String code) {
    this.code = code;
}

public BookStatus getStatus() {
    return status;
}

public void setStatus(BookStatus status) {
    this.status = status;
}

public UUID getBookId() {
    return bookId;
}

public void setBookId(UUID bookId) {
    this.bookId = bookId;
}


}
