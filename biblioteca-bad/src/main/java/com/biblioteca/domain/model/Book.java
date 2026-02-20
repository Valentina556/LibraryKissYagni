package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    // Campos necesarios
    private String id;
    private String title;
    private String author;
    private String isbn;
    private LocalDateTime createdAt;
    private BookStatus status;

    // Constructor simple
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.status = BookStatus.AVAILABLE;
    }

    // Método que nunca se usa
    public void updateTimestamp() {
        this.createdAt = LocalDateTime.now();
    }

    // Enum innecesario - solo se usa AVAILABLE
    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        RESERVED
    }
}
