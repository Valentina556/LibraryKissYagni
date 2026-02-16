package com.biblioteca.domain.policy;

import com.biblioteca.domain.model.Book;
import com.biblioteca.domain.model.User;
import org.springframework.stereotype.Component;

/**
 * Implementación que siempre retorna valores fijos
 */
@Component
public class DefaultLoanPolicy implements LoanPolicy {
    
    @Override
    public boolean canLoan(Book book, User user) {
        // Por ahora siempre permite - entonces ¿para qué existe?
        return true;
    }

    @Override
    public int getLoanDurationDays() {
        // Valor fijo que nunca cambia
        return 14;
    }

    @Override
    public int getMaxLoansPerUser() {
        // Otro valor fijo innecesario
        return 3;
    }
}
