package com.example.booksManager.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ReviewRequestDto(
        @NotBlank(message = "book id cannot be empty")
        Long bookId,
        @Min(value = 0, message = "Rating must be at least 0")
        @Max(value = 10, message = "Rating must be at most 10")
        Integer rating,
        @NotBlank(message = "comment cannot be empty")
        String commentText

) {
}
