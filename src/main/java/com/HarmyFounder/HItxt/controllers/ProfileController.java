package com.HarmyFounder.HItxt.controllers;

import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("/{channel_id}")
    public User changeSubStatus(@AuthenticationPrincipal User subscriber,
                                @PathVariable("channel_id") User channel) {
        if (subscriber.equals(channel)) {
            return channel;
        } else {
            return profileService.changeSubStatus(subscriber,channel);
        }

    }

}
