package com.example.booksManager.service;

import java.util.List;

public interface CrudService<T, U> {
    T save(U request);
    List<T> findAll();
    T findById(Long id);
    T update(Long id, U request);
    void remove(Long id);
}
