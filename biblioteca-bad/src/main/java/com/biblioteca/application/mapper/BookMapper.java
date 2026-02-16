package com.biblioteca.application.mapper;

import com.biblioteca.application.dto.BookResponseDTO;
import com.biblioteca.domain.model.Book;
import org.springframework.stereotype.Component;

/**
 * Mapper para conversiones triviales que no agregan valor
 */
@Component
public class BookMapper {
    
    public BookResponseDTO toResponseDTO(Book book, boolean available, String message) {
        if (book == null) {
            return new BookResponseDTO(null, null, null, false, "Libro no encontrado");
        }
        
        return new BookResponseDTO(
            book.getId(),
            book.getTitle(),
            book.getAuthor(),
            available,
            message
        );
    }

    // Método que nunca se usa
    public Book toEntity(BookResponseDTO dto) {
        if (dto == null) {
            return null;
        }
        
        return new Book(dto.getBookId(), dto.getTitle(), dto.getAuthor());
    }
}
