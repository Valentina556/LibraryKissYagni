package com.biblioteca.infrastructure.factory;

import com.biblioteca.domain.model.Book;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Factory innecesario para crear objetos simples
 */
@Component
public class BookFactory {
    
    public Book createBook(String title, String author) {
        String id = UUID.randomUUID().toString();
        return new Book(id, title, author);
    }

    public Book createBookWithId(String id, String title, String author) {
        return new Book(id, title, author);
    }

    // Método que nunca se usa
    public Book createBookWithISBN(String title, String author, String isbn) {
        Book book = createBook(title, author);
        book.setIsbn(isbn);
        return book;
    }
}
