package com.HarmyFounder.HItxt.controllers;

import com.HarmyFounder.HItxt.models.Post;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.service.FavoriteListService;
import com.HarmyFounder.HItxt.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FavoriteListService favoriteListService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('posts:write')")
    public Post createPost(@RequestBody Post post, @AuthenticationPrincipal User user) {
        post.setAuthor(user);
        return postService.createPost(post);
    }

    @PutMapping("/{id}/update")
    @PreAuthorize("hasAuthority('posts:write')")
    public Post updatePost(@PathVariable("id") Post postFromDb, @RequestBody Post post) {
        return postService.update(postFromDb, post);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('posts:write')")
    public void deletePost(@PathVariable("id") Post post) {
        postService.delete(post);
    }

    @PostMapping("/{id}/addToFav")
    @PreAuthorize("hasAuthority('posts:read')")
    public Post addToFavorites(@PathVariable("id") Post post, @AuthenticationPrincipal User user) {
        return favoriteListService.addToFavorite(post, user);
    }

    @PostMapping("/{id}/mod/del")
    @PreAuthorize("hasAuthority('posts:moderate')")
    public void moderationDel(@PathVariable("id")Post post, @AuthenticationPrincipal User user){
        postService.moderationDel(post,user);
    }

}
