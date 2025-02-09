package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.entity.auth.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersService {
    public UserDetails loadUserByUsername(String username);
    public String addUser(Users users);
}
