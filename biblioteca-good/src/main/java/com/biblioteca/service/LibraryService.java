package com.biblioteca.service;

import com.biblioteca.model.Book;
import com.biblioteca.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryService {
    
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, User> loans = new HashMap<>(); // bookId -> User

    public LibraryService() {
        // Datos de prueba
        books.put("1", new Book("1", "El Quijote", "Cervantes"));
        books.put("2", new Book("2", "Cien Años de Soledad", "García Márquez"));
        books.put("3", new Book("3", "1984", "George Orwell"));

        users.put("1", new User("1", "Juan Pérez"));
        users.put("2", new User("2", "María Gómez"));
        users.put("3", new User("3", "Pedro Rodríguez"));
    }

    public boolean borrowBook(String bookId, String userId) {
        Book book = books.get(bookId);
        User user = users.get(userId);

        if (book == null || user == null) {
            return false;
        }
        
        if (loans.containsKey(bookId)) {
            return false;
        }
        
        loans.put(bookId, user);
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
