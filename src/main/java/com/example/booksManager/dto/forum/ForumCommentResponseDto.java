package com.example.booksManager.dto.forum;

import com.example.booksManager.entity.Forum;

public record ForumCommentResponseDto(
        Long id,
        String commentText,
        Long userId,
        Forum forumId
) {
}
