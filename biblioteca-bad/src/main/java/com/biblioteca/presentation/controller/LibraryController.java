package com.biblioteca.presentation.controller;

import com.biblioteca.application.dto.BookResponseDTO;
import com.biblioteca.application.dto.LoanRequestDTO;
import com.biblioteca.application.dto.LoanResponseDTO;
import com.biblioteca.application.mapper.BookMapper;
import com.biblioteca.domain.model.Book;
import com.biblioteca.domain.service.LibraryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class LibraryController {
    
    private static final Logger logger = LoggerFactory.getLogger(LibraryController.class);
    
    private final LibraryManager libraryManager;
    private final BookMapper bookMapper;

    public LibraryController(LibraryManager libraryManager, BookMapper bookMapper) {
        this.libraryManager = libraryManager;
        this.bookMapper = bookMapper;
        logger.info("LibraryController inicializado");
    }

    @PostMapping("/borrow")
    public ResponseEntity<LoanResponseDTO> borrowBook(@RequestBody LoanRequestDTO request) {
        logger.info("POST /api/books/borrow - Request: {}", request);
        
        try {
            boolean success = libraryManager.borrowBook(request.getBookId(), request.getUserId());
            
            LoanResponseDTO response = new LoanResponseDTO(
                success,
                success ? "Libro prestado exitosamente" : "No se pudo prestar el libro",
                request.getBookId(),
                request.getUserId()
            );
            
            logger.info("Respuesta: {}", response);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error al prestar libro", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new LoanResponseDTO(false, "Error interno", null, null));
        }
    }

    @PostMapping("/return")
    public ResponseEntity<LoanResponseDTO> returnBook(@RequestBody LoanRequestDTO request) {
        logger.info("POST /api/books/return - Request: {}", request);
        
        try {
            boolean success = libraryManager.returnBook(request.getBookId());
            
            LoanResponseDTO response = new LoanResponseDTO(
                success,
                success ? "Libro devuelto exitosamente" : "No se pudo devolver el libro",
                request.getBookId(),
                request.getUserId()
            );
            
            logger.info("Respuesta: {}", response);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error al devolver libro", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new LoanResponseDTO(false, "Error interno", null, null));
        }
    }

    @GetMapping("/{id}/available")
    public ResponseEntity<BookResponseDTO> checkAvailability(@PathVariable String id) {
        logger.info("GET /api/books/{}/available", id);
        
        try {
            boolean available = libraryManager.isAvailable(id);
            Book book = libraryManager.getAllBooks().get(id);
            
            BookResponseDTO response = bookMapper.toResponseDTO(
                book,
                available,
                available ? "Libro disponible" : "Libro no disponible"
            );
            
            logger.info("Respuesta: {}", response);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error al consultar disponibilidad", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new BookResponseDTO(null, null, null, false, "Error interno"));
        }
    }

    // Endpoint que nadie pidió
    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        logger.info("GET /api/books");
        return ResponseEntity.ok(libraryManager.getAllBooks());
    }
}
