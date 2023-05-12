package com.example.booksManager.controller;

import com.example.booksManager.dto.forum.ForumRequestDto;
import com.example.booksManager.dto.forum.ForumResponseDto;
import com.example.booksManager.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/forums")
public class ForumController {

    private final ForumService forumService;

    @PostMapping
    public ResponseEntity<ForumResponseDto> addForum(
            @RequestBody ForumRequestDto requestDto,
            @RequestParam("user") Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(forumService.save(requestDto, userId));
    }

    @GetMapping
    public ResponseEntity<List<ForumResponseDto>> getAllForums() {
        return ResponseEntity.ok(forumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumResponseDto> getForum(@PathVariable Long id) {
        return ResponseEntity.ok(forumService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ForumResponseDto> updateForum(
            @PathVariable Long id,
            @RequestBody ForumRequestDto requestDto,
            @RequestParam("user") Long userId
    ) {
        return ResponseEntity.accepted().body(forumService.update(id, requestDto, userId));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForum(@PathVariable Long id) {
        forumService.remove(id);
        return ResponseEntity.noContent().build();
    }
}

