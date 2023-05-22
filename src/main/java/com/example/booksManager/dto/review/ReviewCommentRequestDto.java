package com.example.booksManager.dto.review;

import jakarta.validation.constraints.NotBlank;

public record ReviewCommentRequestDto(
        @NotBlank(message = "comment cannot be empty")
        String commentText,
        @NotBlank(message = "review id cannot be empty")
        Long reviewId
) {
}
