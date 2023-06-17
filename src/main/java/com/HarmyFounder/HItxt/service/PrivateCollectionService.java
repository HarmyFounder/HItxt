package com.HarmyFounder.HItxt.service;

import com.HarmyFounder.HItxt.models.Post;
import com.HarmyFounder.HItxt.models.PrivateCollection;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.repos.PrivateCollectionRepository;
import com.HarmyFounder.HItxt.repos.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateCollectionService {

    @Autowired
    private PrivateCollectionRepository privateCollectionRepository;

    @Autowired
    private UserDetailRepo userDetailRepo;

    public Post addPostToPrivateCollection(User user, Post post, PrivateCollection privateCollection){

        privateCollection.getPrivateCollection().add(post);

        userDetailRepo.save(user);

        return post;
    }



}
