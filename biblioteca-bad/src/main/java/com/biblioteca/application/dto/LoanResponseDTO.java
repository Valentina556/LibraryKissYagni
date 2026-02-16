package com.biblioteca.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Más DTOs que complican todo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponseDTO {
    private boolean success;
    private String message;
    private String bookId;
    private String userId;
}
