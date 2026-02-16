package com.biblioteca.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidad Loan que complica todo cuando solo necesitábamos un Map
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    private String id;
    private String bookId;
    private String userId;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private LoanStatus status;
    private Double fineAmount; // Nadie pidió multas

    public Loan(String id, String bookId, String userId) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = LocalDateTime.now();
        this.dueDate = LocalDateTime.now().plusDays(14);
        this.status = LoanStatus.ACTIVE;
        this.fineAmount = 0.0;
    }

    // Método que nunca se usa
    public boolean isOverdue() {
        return LocalDateTime.now().isAfter(dueDate) && status == LoanStatus.ACTIVE;
    }

    // Método que nunca se usa
    public long getDaysOverdue() {
        if (!isOverdue()) return 0;
        return java.time.Duration.between(dueDate, LocalDateTime.now()).toDays();
    }

    public enum LoanStatus {
        ACTIVE,
        RETURNED,
        OVERDUE,
        CANCELLED
    }
}
