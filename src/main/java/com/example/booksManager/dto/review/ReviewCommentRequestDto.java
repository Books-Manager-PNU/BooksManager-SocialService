package com.example.booksManager.dto.review;

import com.example.booksManager.entity.Review;
import jakarta.validation.constraints.NotBlank;

public record ReviewCommentRequestDto(
        @NotBlank(message = "comment cannot be empty")
        String commentText,
        @NotBlank(message = "review id cannot be empty")
        Review reviewId
) {
}
