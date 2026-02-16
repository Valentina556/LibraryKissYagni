package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidad Book con campos innecesarios - MALA PRÁCTICA
 * Solo necesitamos: id, title, author
 * Pero agregamos campos "por si acaso"
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    // Campos necesarios
    private String id;
    private String title;
    private String author;
    
    // Campos innecesarios - nadie los pidió
    private String isbn; // ❌ Nadie lo pidió
    private LocalDateTime createdAt; // ❌ Nadie lo pidió
    private BookStatus status; // ❌ Complicación innecesaria

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

    // Enum innecesario - solo usamos AVAILABLE
    public enum BookStatus {
        AVAILABLE,
        BORROWED,
        RESERVED
    }
}
