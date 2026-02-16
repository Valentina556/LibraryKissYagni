package com.biblioteca.controller;

import com.biblioteca.model.Book;
import com.biblioteca.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Controller simple - sin DTOs innecesarios
 */
@RestController
@RequestMapping("/api/books")
public class LibraryController {
    
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/borrow")
    public ResponseEntity<Map<String, Object>> borrowBook(@RequestBody Map<String, String> request) {
        String bookId = request.get("bookId");
        String userId = request.get("userId");
        
        boolean success = libraryService.borrowBook(bookId, userId);
        
        return ResponseEntity.ok(Map.of(
            "success", success,
            "message", success ? "Libro prestado exitosamente" : "No se pudo prestar el libro"
        ));
    }

    @PostMapping("/return")
    public ResponseEntity<Map<String, Object>> returnBook(@RequestBody Map<String, String> request) {
        String bookId = request.get("bookId");
        
        boolean success = libraryService.returnBook(bookId);
        
        return ResponseEntity.ok(Map.of(
            "success", success,
            "message", success ? "Libro devuelto exitosamente" : "No se pudo devolver el libro"
        ));
    }

    @GetMapping("/{id}/available")
    public ResponseEntity<Map<String, Object>> checkAvailability(@PathVariable String id) {
        boolean available = libraryService.isAvailable(id);
        Book book = libraryService.getBook(id);
        
        if (book == null) {
            return ResponseEntity.ok(Map.of(
                "available", false,
                "message", "Libro no encontrado"
            ));
        }
        
        return ResponseEntity.ok(Map.of(
            "bookId", book.getId(),
            "title", book.getTitle(),
            "author", book.getAuthor(),
            "available", available,
            "message", available ? "Libro disponible" : "Libro no disponible"
        ));
    }
}
