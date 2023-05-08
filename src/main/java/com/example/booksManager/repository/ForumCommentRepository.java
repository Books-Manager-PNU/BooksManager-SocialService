package com.example.booksManager.repository;

import com.example.booksManager.entity.ForumComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumCommentRepository extends JpaRepository<ForumComment, Long> {
}
