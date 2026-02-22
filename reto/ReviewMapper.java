package com.biblioteca.challenge.review;

import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewDTO toDTO(Review review) {
        if (review == null)
            return null;
        return new ReviewDTO(
                review.getId(),
                review.getBookId(),
                review.getUserId(),
                review.getComment(),
                review.getRating(),
                review.getStatus(),
                review.getCreatedAt());
    }

    public Review toEntity(ReviewDTO dto) {
        if (dto == null)
            return null;
        Review review = new Review(dto.getId(), dto.getBookId(), dto.getUserId(), dto.getComment(), dto.getRating());
        review.setStatus(dto.getStatus());
        review.setCreatedAt(dto.getDate());
        return review;
    }
}
