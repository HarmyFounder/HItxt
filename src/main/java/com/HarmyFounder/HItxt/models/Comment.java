package com.HarmyFounder.HItxt.models;

import jakarta.persistence.*;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String text;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User author;

    public Comment() {
    }

    public Comment(String text, Post post, User author) {
        this.text = text;
        this.post = post;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
