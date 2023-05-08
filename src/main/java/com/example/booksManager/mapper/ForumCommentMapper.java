package com.example.booksManager.mapper;

import com.example.booksManager.dto.forum.ForumCommentRequestDto;
import com.example.booksManager.dto.forum.ForumCommentResponseDto;
import com.example.booksManager.entity.ForumComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ForumCommentMapper {
    ForumCommentResponseDto toResponseDto(ForumComment forumComment);
    ForumComment toEntity(ForumCommentRequestDto forumCommentRequest);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ForumCommentRequestDto forumCommentRequest, @MappingTarget ForumComment forumComment);
}
