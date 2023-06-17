package com.HarmyFounder.HItxt.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class PrivateCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany
    @JoinTable(name = "post_collection",
            joinColumns = @JoinColumn(name = "post_id"))
    private List<Post> privateCollection;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Post> getPrivateCollection() {
        return privateCollection;
    }

    public void setPrivateCollection(List<Post> privateCollection) {
        this.privateCollection = privateCollection;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
