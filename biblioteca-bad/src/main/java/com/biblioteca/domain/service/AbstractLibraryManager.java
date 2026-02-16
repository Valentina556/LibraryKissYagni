package com.biblioteca.domain.service;

import com.biblioteca.domain.model.Book;
import com.biblioteca.domain.model.User;
import com.biblioteca.domain.policy.FinePolicy;
import com.biblioteca.domain.policy.LoanPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jerarquía innecesaria - clase abstracta que solo tiene una implementación
 */
public abstract class AbstractLibraryManager {
    
    protected static final Logger logger = LoggerFactory.getLogger(AbstractLibraryManager.class);
    
    protected LoanPolicy loanPolicy;
    protected FinePolicy finePolicy;
    protected NotificationService notificationService;

    public AbstractLibraryManager(LoanPolicy loanPolicy, 
                                  FinePolicy finePolicy,
                                  NotificationService notificationService) {
        this.loanPolicy = loanPolicy;
        this.finePolicy = finePolicy;
        this.notificationService = notificationService;
        logger.info("Inicializando AbstractLibraryManager con políticas");
    }

    // Método abstracto que fuerza implementación innecesaria
    abstract void processLoan(Book book, User user);

    // Método que nunca se usa
    protected void logOperation(String operation, String details) {
        logger.debug("Operación: {} - Detalles: {}", operation, details);
    }

    // Template method que nadie pidió
    protected boolean validateLoan(Book book, User user) {
        logger.debug("Validando préstamo para libro {} y usuario {}", book.getId(), user.getId());
        return loanPolicy.canLoan(book, user);
    }
}
