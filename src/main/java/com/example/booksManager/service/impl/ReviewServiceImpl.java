package com.example.booksManager.service.impl;

import com.example.booksManager.dto.review.ReviewRequestDto;
import com.example.booksManager.dto.review.ReviewResponseDto;
import com.example.booksManager.entity.Review;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.ReviewMapper;
import com.example.booksManager.repository.ReviewRepository;
import com.example.booksManager.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponseDto save(ReviewRequestDto request) {
        Review review = reviewMapper.toEntity(request);
        return reviewMapper.toResponseDto(reviewRepository.save(review));
    }

    @Override
    public List<ReviewResponseDto> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::toResponseDto)
                .toList();
    }

    @Override
    public ReviewResponseDto findById(Long id) {
        Review review = getExistingForumById(id);
        return reviewMapper.toResponseDto(reviewRepository.save(review));
    }

    @Override
    public ReviewResponseDto update(Long id, ReviewRequestDto request) {
        Review review = getExistingForumById(id);
        reviewMapper.updateEntity(request, review);
        reviewRepository.save(review);
        return reviewMapper.toResponseDto(review);
    }

    @Override
    public void remove(Long id) {
        Review review = getExistingForumById(id);
        reviewRepository.delete(review);
    }

    private Review getExistingForumById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Review not found"));
    }
}
