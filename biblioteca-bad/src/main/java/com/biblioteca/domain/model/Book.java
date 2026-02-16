package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad Book con validaciones excesivas y campos innecesarios
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String id;
    private String title;
    private String author;
    private String isbn; // Nadie lo pidió
    private LocalDateTime createdAt; // Nadie lo pidió
    private LocalDateTime updatedAt; // Nadie lo pidió
    private BookStatus status; // Complicación innecesaria
    private String category; // Nadie lo pidió
    private Integer totalCopies; // Nadie lo pidió
    private Integer availableCopies; // Nadie lo pidió

    // Constructor "útil" que tampoco se usa
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = BookStatus.AVAILABLE;
        this.totalCopies = 1;
        this.availableCopies = 1;
    }

    // Validación compleja que nadie pidió
    public boolean isValid() {
        return Objects.nonNull(id) && 
               !id.isEmpty() && 
               Objects.nonNull(title) && 
               !title.isEmpty() &&
               Objects.nonNull(author) && 
               !author.isEmpty() &&
               title.length() >= 3 &&
               author.length() >= 3;
    }

    // Método que nunca se usa
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }

    // Enum innecesario
    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        RESERVED,
        MAINTENANCE,
        LOST
    }
}
