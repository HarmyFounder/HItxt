package com.HarmyFounder.HItxt.service;

import com.HarmyFounder.HItxt.models.Post;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.repos.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FavoriteListService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    public Post addToFavorite(Post post, User user) {

        Set<Post> favoriteList = user.getFavoriteList();

        if(favoriteList.contains(post)){
            favoriteList.remove(post);
        } else {
            favoriteList.add(post);
        }

        userDetailRepo.save(user);

        return post;
    }


}
