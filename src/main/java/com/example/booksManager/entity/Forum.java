package com.example.booksManager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "forum", schema = "public")
public class Forum {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @PrePersist
    public void createEntity() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    public void updateEntity() {
        updateDate = LocalDateTime.now();
    }
}