package com.example.booksManager.controller;

import com.example.booksManager.dto.forum.ForumCommentRequestDto;
import com.example.booksManager.dto.forum.ForumCommentResponseDto;
import com.example.booksManager.service.impl.ForumCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/forum-comments")
public class ForumCommentController {

    private final ForumCommentService forumCommentService;

    @PostMapping
    public ResponseEntity<ForumCommentResponseDto> addForumComment(
            @RequestBody ForumCommentRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(forumCommentService.save(requestDto, userId));
    }

    @GetMapping
    public ResponseEntity<List<ForumCommentResponseDto>> getAllForumComments() {
        return ResponseEntity.ok(forumCommentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumCommentResponseDto> getForumComment(@PathVariable Long id) {
        return ResponseEntity.ok(forumCommentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumCommentResponseDto> updateForumComment(
            @PathVariable Long id,
            @RequestBody ForumCommentRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.accepted()
                .body(forumCommentService.update(id, requestDto, userId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForumComment(@PathVariable Long id) {
        forumCommentService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

