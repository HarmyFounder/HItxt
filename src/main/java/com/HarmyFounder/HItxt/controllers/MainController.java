package com.HarmyFounder.HItxt.controllers;

import com.HarmyFounder.HItxt.models.Post;
import com.HarmyFounder.HItxt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getAll() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getCertain(@PathVariable("id") Post post){
        return post;
    }

}
