package com.example.booksManager.dto.review;

public record ReviewResponseDto(
        Long id,
        Long userId,
        Long bookId,
        Integer rating,
        String commentText
) {
}
