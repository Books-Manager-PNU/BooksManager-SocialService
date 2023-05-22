package com.example.booksManager.dto.forum;

import jakarta.validation.constraints.NotBlank;

public record ForumCommentRequestDto(
        @NotBlank(message = "comment cannot be empty")
        String commentText,
        @NotBlank(message = "forum id cannot be empty")
        Long forumId
) {
}
