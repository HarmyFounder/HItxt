package com.HarmyFounder.HItxt.repos;

import com.HarmyFounder.HItxt.models.Post;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @EntityGraph(attributePaths = {"comments"})
    List<Post> findAll();
    List<Post> findByTag(String tag);
}
