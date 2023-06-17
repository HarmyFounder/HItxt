package com.HarmyFounder.HItxt.repos;

import com.HarmyFounder.HItxt.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepo extends JpaRepository<User, String> {

    @EntityGraph(attributePaths = {"subscriptions, subscribers, favoriteList, privateCollections"})
    Optional<User> findById(String s);
}
