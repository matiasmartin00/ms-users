package com.proyectum.users.infrastructure.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public String getCurrentUsername() {
        var context = SecurityContextHolder.getContext();
        var authority = context.getAuthentication();
        var userDetails = (UserDetails) authority.getPrincipal();
        return userDetails.getUsername();
    }
}
