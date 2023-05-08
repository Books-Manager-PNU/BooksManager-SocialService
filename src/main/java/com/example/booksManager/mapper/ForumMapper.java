package com.example.booksManager.mapper;

import com.example.booksManager.dto.forum.ForumRequestDto;
import com.example.booksManager.dto.forum.ForumResponseDto;
import com.example.booksManager.entity.Forum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ForumMapper {
    ForumResponseDto toResponseDto(Forum forum);
    Forum toEntity(ForumRequestDto forumRequest);

    @Mapping(target = "id", ignore = true)
    void updateEntity(ForumRequestDto forumRequest, @MappingTarget Forum forum);
}
