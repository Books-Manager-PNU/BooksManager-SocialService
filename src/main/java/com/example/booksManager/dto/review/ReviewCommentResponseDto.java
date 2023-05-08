package com.example.booksManager.dto.review;

import com.example.booksManager.entity.Review;

public record ReviewCommentResponseDto(
        Long id,
        String commentText,
        Long userId,
        Review reviewId
) {
}
