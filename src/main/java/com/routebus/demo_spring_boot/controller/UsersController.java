package com.routebus.demo_spring_boot.controller;

import com.routebus.demo_spring_boot.auth.JWTService;
import com.routebus.demo_spring_boot.model.entity.auth.AuthRequest;
import com.routebus.demo_spring_boot.model.entity.auth.Users;
import com.routebus.demo_spring_boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/addNewUser",method = RequestMethod.POST)
    public String addNewUser(@RequestBody Users userInfo) {
        return usersService.addUser(userInfo);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String userProfile() {
        return "Welcome to User Profile";
    }
//
//    @GetMapping("/admin/adminProfile")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public String adminProfile() {
//        return "Welcome to Admin Profile";
//    }

    @RequestMapping(value = "/generateToken", method = RequestMethod.POST)
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
