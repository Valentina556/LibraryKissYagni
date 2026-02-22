package com.biblioteca.challenge.review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/challenge/reviews")
public class ReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO request) {
        logger.info("POST /api/challenge/reviews");

        Review review = reviewService.addReview(
                request.getBookId(),
                request.getUserId(),
                request.getComment(),
                request.getRating());

        return ResponseEntity.ok(reviewMapper.toDTO(review));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<ReviewDTO>> getBookReviews(@PathVariable String bookId) {
        List<Review> reviews = reviewService.getReviewsByBook(bookId);

        List<ReviewDTO> response = reviews.stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
