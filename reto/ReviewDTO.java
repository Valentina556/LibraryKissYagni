package com.biblioteca.challenge.review;

import java.time.LocalDateTime;

public class ReviewDTO {
    private String id;
    private String bookId;
    private String userId;
    private String comment;
    private int rating;
    private String status;
    private LocalDateTime date;

    public ReviewDTO() {
    }

    public ReviewDTO(String id, String bookId, String userId, String comment, int rating, String status,
            LocalDateTime date) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.status = status;
        this.date = date;
    }

    // Getters y Setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
