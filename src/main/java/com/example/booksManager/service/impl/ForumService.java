package com.example.booksManager.service.impl;

import com.example.booksManager.dto.forum.ForumRequestDto;
import com.example.booksManager.dto.forum.ForumResponseDto;
import com.example.booksManager.entity.Forum;
import com.example.booksManager.exception.WebException;
import com.example.booksManager.mapper.ForumMapper;
import com.example.booksManager.repository.ForumRepository;
import com.example.booksManager.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ForumService implements BaseService<ForumResponseDto, ForumRequestDto> {
    private final ForumMapper forumMapper;
    private final ForumRepository forumRepository;

    @Override
    public ForumResponseDto save(ForumRequestDto request, Long userId) {
        Forum forum = forumMapper.toEntity(request);
        forum.setUserId(userId);
        return forumMapper.toResponseDto(forumRepository.save(forum));
    }

    @Override
    public List<ForumResponseDto> findAll() {
        return forumRepository.findAll()
                .stream()
                .map(forumMapper::toResponseDto)
                .toList();
    }

    @Override
    public ForumResponseDto findById(Long id) {
        Forum forum = getExistingForumById(id);
        return forumMapper.toResponseDto(forumRepository.save(forum));
    }

    @Override
    public ForumResponseDto update(Long id, ForumRequestDto request, Long userId) {
        Forum forum = getExistingForumById(id);
        forumMapper.updateEntity(request, forum);
        forum.setUserId(userId);
        forumRepository.save(forum);
        return forumMapper.toResponseDto(forum);
    }

    @Override
    public void remove(Long id) {
        Forum forum = getExistingForumById(id);
        forumRepository.delete(forum);
    }

    private Forum getExistingForumById(Long id) {
        return forumRepository.findById(id)
                .orElseThrow(() -> new WebException(HttpStatus.NOT_FOUND, "Forum not found"));
    }
}
