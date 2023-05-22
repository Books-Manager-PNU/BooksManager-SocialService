package com.example.booksManager.service.impl;

import com.example.booksManager.dto.forum.ForumCommentRequestDto;
import com.example.booksManager.dto.forum.ForumCommentResponseDto;
import com.example.booksManager.entity.ForumComment;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.ForumCommentMapper;
import com.example.booksManager.repository.ForumCommentRepository;
import com.example.booksManager.service.ForumCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ForumCommentServiceImpl implements ForumCommentService {
    private final ForumCommentMapper forumCommentMapper;
    private final ForumCommentRepository forumCommentRepository;

    @Override
    public ForumCommentResponseDto save(ForumCommentRequestDto request) {
        ForumComment comment = forumCommentMapper.toEntity(request);
        return forumCommentMapper.toResponseDto(forumCommentRepository.save(comment));
    }

    @Override
    public List<ForumCommentResponseDto> findAll() {
        return forumCommentRepository.findAll()
                .stream()
                .map(forumCommentMapper::toResponseDto)
                .toList();
    }

    @Override
    public ForumCommentResponseDto findById(Long id) {
        ForumComment comment = getExistingForumById(id);
        return forumCommentMapper.toResponseDto(forumCommentRepository.save(comment));
    }

    @Override
    public ForumCommentResponseDto update(Long id, ForumCommentRequestDto request) {
        ForumComment comment = getExistingForumById(id);
        forumCommentMapper.updateEntity(request, comment);
        forumCommentRepository.save(comment);
        return forumCommentMapper.toResponseDto(comment);
    }

    @Override
    public void remove(Long id) {
        ForumComment comment = getExistingForumById(id);
        forumCommentRepository.delete(comment);
    }

    private ForumComment getExistingForumById(Long id) {
        return forumCommentRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Forum comment not found"));
    }
}
