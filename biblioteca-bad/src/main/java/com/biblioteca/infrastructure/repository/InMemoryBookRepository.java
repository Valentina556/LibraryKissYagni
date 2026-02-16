package com.biblioteca.infrastructure.repository;

import com.biblioteca.domain.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Repository con métodos que nunca se usan
 */
@Repository
public class InMemoryBookRepository implements GenericRepository<Book, String> {
    
    private final Map<String, Book> storage = new HashMap<>();

    @Override
    public Book save(Book entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void deleteById(String id) {
        storage.remove(id);
    }

    @Override
    public boolean existsById(String id) {
        return storage.containsKey(id);
    }

    @Override
    public long count() {
        return storage.size();
    }

    // Métodos adicionales que nadie usa
    public List<Book> findByAuthor(String author) {
        return storage.values().stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .toList();
    }

    public List<Book> findByTitle(String title) {
        return storage.values().stream()
            .filter(book -> book.getTitle().contains(title))
            .toList();
    }
}
