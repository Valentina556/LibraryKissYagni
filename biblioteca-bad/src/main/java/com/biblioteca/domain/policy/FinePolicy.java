package com.biblioteca.domain.policy;

// Política de multas que no existe en los requerimientos
 
public interface FinePolicy {
    double calculateFine(int daysLate);
    double getFinePerDay();
    double getMaxFine();
}
