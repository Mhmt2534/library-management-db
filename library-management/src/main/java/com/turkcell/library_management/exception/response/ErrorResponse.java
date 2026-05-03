package com.turkcell.library_management.exception.response;

public record ErrorResponse(
        String title,
        String type,
        String message
) {
}