package com.routebus.demo_spring_boot.auth;

import com.routebus.demo_spring_boot.model.entity.auth.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UsersInfo implements UserDetails {
    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    public UsersInfo(Users users) {
        this.username = users.getUsername(); // Assuming 'name' is used as 'username'
        this.password = users.getPassword();
//        this.grantedAuthorities = List.of(userInfo.getRoles().split(","))
//                .stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
