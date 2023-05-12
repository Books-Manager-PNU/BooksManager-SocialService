package com.example.booksManager.controller;

import com.example.booksManager.dto.review.ReviewRequestDto;
import com.example.booksManager.dto.review.ReviewResponseDto;
import com.example.booksManager.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> addReview(
            @RequestBody ReviewRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reviewService.save(requestDto, userId));
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getAllReviews() {
        return ResponseEntity.ok(reviewService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getReview(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.accepted().body(reviewService.update(id, requestDto, userId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        reviewService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

