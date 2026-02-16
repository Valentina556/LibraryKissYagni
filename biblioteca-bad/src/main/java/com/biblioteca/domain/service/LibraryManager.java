package com.biblioteca.domain.service;

import com.biblioteca.domain.model.Book;
import com.biblioteca.domain.model.User;
import com.biblioteca.domain.policy.FinePolicy;
import com.biblioteca.domain.policy.LoanPolicy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación concreta con lógica mezclada con herencia innecesaria
 * MALA PRÁCTICA: Extiende AbstractLibraryManager sin necesidad
 */
@Service
public class LibraryManager extends AbstractLibraryManager {
    
    private Map<String, Book> books = new HashMap<>();
    private Map<String, String> loans = new HashMap<>(); // bookId -> userId

    public LibraryManager(LoanPolicy loanPolicy, 
                         FinePolicy finePolicy,
                         NotificationService notificationService) {
        super(loanPolicy, finePolicy, notificationService);
        initializeBooks();
    }

    private void initializeBooks() {
        // Datos de prueba
        books.put("1", new Book("1", "El Quijote", "Cervantes"));
        books.put("2", new Book("2", "Cien Años de Soledad", "García Márquez"));
        books.put("3", new Book("3", "1984", "George Orwell"));
        logger.info("Libros inicializados: {}", books.size());
    }

    @Override
    public void processLoan(Book book, User user) {
        logger.debug("Procesando préstamo - Libro: {}, Usuario: {}", book.getId(), user.getId());
        
        if (validateLoan(book, user)) {
            loans.put(book.getId(), user.getId());
            
            // notificationService nunca se llama realmente
            logOperation("LOAN", "Libro " + book.getId() + " prestado a " + user.getId());
        }
    }

    public boolean borrowBook(String bookId, String userId) {
        logger.info("Intentando prestar libro {} a usuario {}", bookId, userId);
        
        Book book = books.get(bookId);
        if (book == null) {
            logger.warn("Libro no encontrado: {}", bookId);
            return false;
        }

        if (loans.containsKey(bookId)) {
            logger.warn("Libro ya prestado: {}", bookId);
            return false;
        }

        User user = new User(userId, "Usuario " + userId);
        processLoan(book, user);
        
        logger.info("Libro {} prestado exitosamente a {}", bookId, userId);
        return true;
    }

    public boolean returnBook(String bookId) {
        logger.info("Intentando devolver libro {}", bookId);
        
        if (!loans.containsKey(bookId)) {
            logger.warn("Libro no está prestado: {}", bookId);
            return false;
        }

        loans.remove(bookId);
        
        // Cálculo de multa que nunca se usa - MALA PRÁCTICA
        double fine = finePolicy.calculateFine(0);
        
        logger.info("Libro {} devuelto exitosamente. Multa: {}", bookId, fine);
        return true;
    }

    public boolean isAvailable(String bookId) {
        logger.debug("Consultando disponibilidad del libro {}", bookId);
        
        boolean exists = books.containsKey(bookId);
        boolean notLoaned = !loans.containsKey(bookId);
        boolean available = exists && notLoaned;
        
        logger.debug("Libro {} disponible: {}", bookId, available);
        return available;
    }

    // Método adicional que nadie usa - MALA PRÁCTICA
    public Map<String, Book> getAllBooks() {
        return new HashMap<>(books);
    }
}
