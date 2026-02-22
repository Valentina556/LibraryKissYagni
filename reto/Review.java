package com.biblioteca.challenge.review;

import java.time.LocalDateTime;

public class Review {
    private String id;
    private String bookId;
    private String userId;
    private String comment;
    private int rating;
    private String isbn;
    private String reviewerEmail;
    private String status;
    private LocalDateTime createdAt;

    public Review(String id, String bookId, String userId, String comment, int rating) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.createdAt = LocalDateTime.now();
        this.status = "PUBLISHED";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public void setReviewerEmail(String reviewerEmail) {
        this.reviewerEmail = reviewerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
