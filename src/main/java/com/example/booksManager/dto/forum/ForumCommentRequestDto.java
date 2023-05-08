package com.example.booksManager.dto.forum;

import com.example.booksManager.entity.Forum;
import jakarta.validation.constraints.NotBlank;

public record ForumCommentRequestDto(
        @NotBlank(message = "comment cannot be empty")
        String commentText,
        @NotBlank(message = "forum id cannot be empty")
        Forum forumId
) {
}
