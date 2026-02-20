package com.biblioteca.service;

import com.biblioteca.model.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryService {
    
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, String> loans = new HashMap<>(); // bookId -> userId

    public LibraryService() {
        // Datos de prueba
        books.put("1", new Book("1", "El Quijote", "Cervantes"));
        books.put("2", new Book("2", "Cien Años de Soledad", "García Márquez"));
        books.put("3", new Book("3", "1984", "George Orwell"));
    }

    public boolean borrowBook(String bookId, String userId) {
        if (!books.containsKey(bookId)) {
            return false;
        }
        
        if (loans.containsKey(bookId)) {
            return false;
        }
        
        loans.put(bookId, userId);
        return true;
    }

    public boolean returnBook(String bookId) {
        if (!loans.containsKey(bookId)) {
            return false;
        }
        
        loans.remove(bookId);
        return true;
    }

    public boolean isAvailable(String bookId) {
        return books.containsKey(bookId) && !loans.containsKey(bookId);
    }

    public Book getBook(String bookId) {
        return books.get(bookId);
    }
}
