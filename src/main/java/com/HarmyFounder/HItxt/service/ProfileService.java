package com.HarmyFounder.HItxt.service;

import com.HarmyFounder.HItxt.models.Permission;
import com.HarmyFounder.HItxt.models.Role;
import com.HarmyFounder.HItxt.models.User;
import com.HarmyFounder.HItxt.repos.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {

    private static final String DEFAULT_CHECK_KEY = "PROMOTION_KEY";

    @Autowired
    private UserDetailRepo userDetailRepo;

    public User deleteWriteAuthority(User user) {

        Set<Role> roles = user.getRoles();

        if (roles.contains(Role.ADMIN)) {
            return user;
        } else {

            Role[] userRoles = (Role[]) roles.toArray();
            Role currentUserRole = userRoles[userRoles.length - 1];

            currentUserRole.getPermission().remove(Permission.POSTS_WRITE);
            return userDetailRepo.save(user);
        }
    }

    public User changeSubStatus(User user, User channel) {
        Set<User> subscribers = channel.getSubscribers();
        if (subscribers.contains(user)) {
            subscribers.remove(user);
        } else {
            subscribers.add(user);
        }

        return userDetailRepo.save(channel);
    }

    public User getPromoted(User user, String secretKey) {

        Set<Role> roles = user.getRoles();

        if (secretKey.equals(DEFAULT_CHECK_KEY)) {
            if (roles.contains(Role.ADMIN)) {
                return user;
            } else {

                Role[] userRoles = (Role[]) roles.toArray();
                Role currentUserRole = userRoles[userRoles.length - 1];

                currentUserRole.getPermission().add(Permission.USERS_PROMOTED);

                return userDetailRepo.save(user);
            }
        } else {
            return user;
        }
    }
}
