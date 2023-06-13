package com.HarmyFounder.HItxt.controllers;

import com.HarmyFounder.HItxt.models.Post;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post, @AuthenticationPrincipal User user){
        post.setAuthor(user);
        return postService.createPost(post);
    }

    @PutMapping("/{id}/update")
    public Post updatePost(@PathVariable("id")Post postFromDb, @RequestBody Post post){
        return postService.update(postFromDb,post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id")Post post){
        postService.delete(post);
    }

}
