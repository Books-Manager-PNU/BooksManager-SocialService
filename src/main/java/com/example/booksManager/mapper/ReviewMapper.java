package com.example.booksManager.mapper;

import com.example.booksManager.dto.review.ReviewRequestDto;
import com.example.booksManager.dto.review.ReviewResponseDto;
import com.example.booksManager.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewResponseDto toResponseDto(Review review);
    Review toEntity(ReviewRequestDto reviewRequest);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ReviewRequestDto reviewRequest, @MappingTarget Review review);
}
