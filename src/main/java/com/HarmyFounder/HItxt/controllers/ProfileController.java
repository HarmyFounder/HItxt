package com.HarmyFounder.HItxt.controllers;

import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('posts:read')")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("/{channel_id}")
    @PreAuthorize("hasAuthority('posts:read')")
    public User changeSubStatus(@AuthenticationPrincipal User subscriber,
                                @PathVariable("channel_id") User channel) {
        if (subscriber.equals(channel)) {
            return channel;
        } else {
            return profileService.changeSubStatus(subscriber,channel);
        }
    }

    @PostMapping("/{id}/limit")
    @PreAuthorize("hasAuthority('users:moderate')")
    public User limitUser(@PathVariable("id") User user){
        return profileService.deleteWriteAuthority(user);
    }


    //smth like subscription
    @PostMapping("/{id}/getPromotion")
    @PreAuthorize("hasAuthority('posts:read')")
    //smth like special key after transaction
    public User getPromoted(@PathVariable("id") User user, @RequestParam String secretKey){
        return profileService.getPromoted(user,secretKey);
    }


}
