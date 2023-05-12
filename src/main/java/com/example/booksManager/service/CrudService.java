package com.example.booksManager.service;

import java.util.List;

public interface CrudService<T, U> {
    T save(U request, Long userId);
    List<T> findAll();
    T findById(Long id);
    T update(Long id, U request, Long userId);
    void remove(Long id);
}
