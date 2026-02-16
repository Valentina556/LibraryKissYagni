package com.biblioteca.infrastructure.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface genérica compleja que nadie necesita
 */
public interface GenericRepository<T, ID> {
    T save(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    boolean existsById(ID id);
    long count();
}
