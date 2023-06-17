package com.HarmyFounder.HItxt.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User {
    @Id
    private String id;
    private String name;
    private String userPic;
    private String locale;
    private String email;
    private String gender;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_subscriptions",
    joinColumns = @JoinColumn(name = "subscriber_id"),
    inverseJoinColumns = @JoinColumn(name = "channel_id"))
    private Set<User> subscriptions = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "user_subscriptions",
    joinColumns = @JoinColumn(name = "channel_id"),
    inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    private Set<User> subscribers = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "post_id")
    private Set<Post> favoriteList;

    @OneToMany
    @JoinColumn(name = "privateCollection_id")
    private List<PrivateCollection> privateCollections;

    public List<PrivateCollection> getPrivateCollections() {
        return privateCollections;
    }

    public void setPrivateCollections(List<PrivateCollection> privateCollections) {
        this.privateCollections = privateCollections;
    }

    public User() {
    }

    public User(String name, String userPic, String locale, String email, String gender, Set<Role> roles, Set<User> subscriptions, Set<User> subscribers, Set<Post> favoriteList) {
        this.name = name;
        this.userPic = userPic;
        this.locale = locale;
        this.email = email;
        this.gender = gender;
        this.roles = roles;
        this.subscriptions = subscriptions;
        this.subscribers = subscribers;
        this.favoriteList = favoriteList;
    }

    public Set<Post> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(Set<Post> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public Set<User> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
