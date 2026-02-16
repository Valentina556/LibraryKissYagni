package com.biblioteca.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Otro DTO innecesario
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequestDTO {
    private String bookId;
    private String userId;
}
