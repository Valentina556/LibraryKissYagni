package com.biblioteca.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO innecesario para responses simples
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private String bookId;
    private String title;
    private String author;
    private boolean available;
    private String message;
}
