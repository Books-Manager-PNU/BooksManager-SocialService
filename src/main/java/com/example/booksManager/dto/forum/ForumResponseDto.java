package com.example.booksManager.dto.forum;

public record ForumResponseDto(
        Long id,
        String title,
        String description,
        Long userId

) {
}
