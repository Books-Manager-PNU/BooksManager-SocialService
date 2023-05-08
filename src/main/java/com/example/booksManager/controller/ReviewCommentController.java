package com.example.booksManager.controller;

import com.example.booksManager.dto.review.ReviewCommentRequestDto;
import com.example.booksManager.dto.review.ReviewCommentResponseDto;
import com.example.booksManager.service.impl.ReviewCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review-comments")
public class ReviewCommentController {

    private final ReviewCommentService reviewCommentService;

    @PostMapping
    public ResponseEntity<ReviewCommentResponseDto> addReviewComment(
            @RequestBody ReviewCommentRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewCommentService.save(requestDto, userId));
    }

    @GetMapping
    public ResponseEntity<List<ReviewCommentResponseDto>> getAllReviewComments() {
        return ResponseEntity.ok(reviewCommentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewCommentResponseDto> getReviewComment(@PathVariable Long id) {
        return ResponseEntity.ok(reviewCommentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewCommentResponseDto> updateReviewComment(
            @PathVariable Long id,
            @RequestBody ReviewCommentRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.accepted().body(reviewCommentService.update(id, requestDto, userId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewComment(@PathVariable Long id) {
        reviewCommentService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

