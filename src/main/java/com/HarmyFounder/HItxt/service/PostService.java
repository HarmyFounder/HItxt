package com.HarmyFounder.HItxt.service;

import com.HarmyFounder.HItxt.models.Post;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.repos.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post update(Post postFromDb, Post post) {
        BeanUtils.copyProperties(post, postFromDb, "id");
        return postRepository.save(postFromDb);
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public void moderationDel(Post post, User user) {
        postRepository.delete(post);
    }
}
