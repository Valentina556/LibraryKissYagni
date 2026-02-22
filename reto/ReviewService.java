package com.biblioteca.challenge.review;

import com.biblioteca.domain.service.LibraryManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
    private final List<Review> reviews = new ArrayList<>();
    private final LibraryManager libraryManager;

    public ReviewService(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public Review addReview(String bookId, String userId, String comment, int rating) {
        logger.debug("Agregando reseña en challenge package");

        if (libraryManager.getAllBooks().get(bookId) == null) {
            throw new RuntimeException("Libro inexistente");
        }

        Review review = new Review(UUID.randomUUID().toString(), bookId, userId, comment, rating);
        reviews.add(review);
        return review;
    }

    public List<Review> getReviewsByBook(String bookId) {
        return reviews.stream()
                .filter(r -> r.getBookId().equals(bookId))
                .collect(Collectors.toList());
    }
}
