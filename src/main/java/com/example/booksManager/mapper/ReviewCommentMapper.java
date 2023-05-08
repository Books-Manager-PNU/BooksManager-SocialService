package com.example.booksManager.mapper;

import com.example.booksManager.dto.review.ReviewCommentRequestDto;
import com.example.booksManager.dto.review.ReviewCommentResponseDto;
import com.example.booksManager.entity.ReviewComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewCommentMapper {
    ReviewCommentResponseDto toResponseDto(ReviewComment reviewComment);
    ReviewComment toEntity(ReviewCommentRequestDto reviewCommentRequest);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ReviewCommentRequestDto reviewCommentRequest, @MappingTarget ReviewComment reviewComment);
}
