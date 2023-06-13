package com.HarmyFounder.HItxt.service;

import com.HarmyFounder.HItxt.models.Comment;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.repos.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        commentRepository.save(comment);
        return comment;
    }
}
