package com.HarmyFounder.HItxt.controllers;

import com.HarmyFounder.HItxt.models.Comment;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Comment comment(@RequestBody Comment comment, @AuthenticationPrincipal User user){
        return commentService.create(comment,user);
    }

}
