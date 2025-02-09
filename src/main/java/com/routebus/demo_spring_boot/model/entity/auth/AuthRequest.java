package com.routebus.demo_spring_boot.model.entity.auth;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
