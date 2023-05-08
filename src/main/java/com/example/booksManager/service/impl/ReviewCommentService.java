package com.example.booksManager.service.impl;

import com.example.booksManager.dto.review.ReviewCommentRequestDto;
import com.example.booksManager.dto.review.ReviewCommentResponseDto;
import com.example.booksManager.entity.ReviewComment;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.ReviewCommentMapper;
import com.example.booksManager.repository.ReviewCommentRepository;
import com.example.booksManager.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewCommentService implements BaseService<ReviewCommentResponseDto, ReviewCommentRequestDto> {
    private final ReviewCommentMapper reviewCommentMapper;
    private final ReviewCommentRepository reviewCommentRepository;

    @Override
    public ReviewCommentResponseDto save(ReviewCommentRequestDto request, Long userId) {
        ReviewComment comment = reviewCommentMapper.toEntity(request);
        comment.setUserId(userId);
        return reviewCommentMapper.toResponseDto(reviewCommentRepository.save(comment));
    }

    @Override
    public List<ReviewCommentResponseDto> findAll() {
        return reviewCommentRepository.findAll()
                .stream()
                .map(reviewCommentMapper::toResponseDto)
                .toList();
    }

    @Override
    public ReviewCommentResponseDto findById(Long id) {
        ReviewComment comment = getExistingForumById(id);
        return reviewCommentMapper.toResponseDto(reviewCommentRepository.save(comment));
    }

    @Override
    public ReviewCommentResponseDto update(Long id, ReviewCommentRequestDto request, Long userId) {
        ReviewComment comment = getExistingForumById(id);
        reviewCommentMapper.updateEntity(request, comment);
        comment.setUserId(userId);
        reviewCommentRepository.save(comment);
        return reviewCommentMapper.toResponseDto(comment);
    }

    @Override
    public void remove(Long id) {
        ReviewComment comment = getExistingForumById(id);
        reviewCommentRepository.delete(comment);
    }

    private ReviewComment getExistingForumById(Long id) {
        return reviewCommentRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Review comment not found"));
    }
}
