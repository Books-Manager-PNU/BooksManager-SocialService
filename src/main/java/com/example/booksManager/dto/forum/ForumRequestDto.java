package com.example.booksManager.dto.forum;

import jakarta.validation.constraints.NotBlank;

public record ForumRequestDto(
        @NotBlank(message = "title cannot be empty")
        String title,
        @NotBlank(message = "description cannot be empty")
        String description

) {
}
