package com.example.booksManager.dto.review;

public record ReviewCommentResponseDto(
        Long id,
        String commentText,
        Long userId,
        Long reviewId
) {
}
