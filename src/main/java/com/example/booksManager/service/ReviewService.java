package com.example.booksManager.service;

import com.example.booksManager.dto.review.ReviewRequestDto;
import com.example.booksManager.dto.review.ReviewResponseDto;

public interface ReviewService extends CrudService<ReviewResponseDto, ReviewRequestDto> {
}
