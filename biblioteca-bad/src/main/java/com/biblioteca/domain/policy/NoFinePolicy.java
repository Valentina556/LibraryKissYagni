package com.biblioteca.domain.policy;

import org.springframework.stereotype.Component;

/**
 * No hay multas, pero existe la clase de todas formas
 */
@Component
public class NoFinePolicy implements FinePolicy {
    
    @Override
    public double calculateFine(int daysLate) {
        // Siempre retorna 0, entonces ¿para qué existe?
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
