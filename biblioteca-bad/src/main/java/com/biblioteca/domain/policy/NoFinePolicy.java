package com.biblioteca.domain.policy;

import org.springframework.stereotype.Component;

/**
 * En el sistema todavía no hay multas
 */
@Component
public class NoFinePolicy implements FinePolicy {
    
    @Override
    public double calculateFine(int daysLate) {
        return 0.0;
    }

    @Override
    public double getFinePerDay() {
        return 0.0;
    }

    @Override
    public double getMaxFine() {
        return 0.0;
    }
}
