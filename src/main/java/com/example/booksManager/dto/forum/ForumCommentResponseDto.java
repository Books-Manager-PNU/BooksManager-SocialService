package com.example.booksManager.dto.forum;

public record ForumCommentResponseDto(
        Long id,
        String commentText,
        Long userId,
        Long forumId
) {
}
