package com.biblioteca.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO innecesario para requests simples
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
    private String bookId;
    private String userId;
}
