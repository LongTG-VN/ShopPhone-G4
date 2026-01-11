/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author CT
 */
public class Review {
    private int reviewID;
    private User user;
    private Product product;
    private int rating;
    private String comment;
    private byte is_active;
    private String review_image_url;
    private LocalDateTime created_at;

    public Review() {
    }

    public Review(int reviewID, User user, Product product, int rating, String comment, byte is_active, String review_image_url, LocalDateTime created_at) {
        this.reviewID = reviewID;
        this.user = user;
        this.product = product;
        this.rating = rating;
        this.comment = comment;
        this.is_active = is_active;
        this.review_image_url = review_image_url;
        this.created_at = created_at;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte getIs_active() {
        return is_active;
    }

    public void setIs_active(byte is_active) {
        this.is_active = is_active;
    }

    public String getReview_image_url() {
        return review_image_url;
    }

    public void setReview_image_url(String review_image_url) {
        this.review_image_url = review_image_url;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Review{" + "reviewID=" + reviewID + ", user=" + user + ", product=" + product + ", rating=" + rating + ", comment=" + comment + ", is_active=" + is_active + ", review_image_url=" + review_image_url + ", created_at=" + created_at + '}';
    }
    
    
}
