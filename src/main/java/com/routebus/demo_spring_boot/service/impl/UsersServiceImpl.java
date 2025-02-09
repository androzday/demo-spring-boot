package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.auth.UsersInfo;
import com.routebus.demo_spring_boot.model.entity.auth.Users;
import com.routebus.demo_spring_boot.repository.UsersRepository;
import com.routebus.demo_spring_boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UserDetailsService, UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> users = usersRepository.findByUsername(username); // Assuming 'email' is used as username
        System.out.println("SINI USER");
        System.out.println(users);
        // Converting UserInfo to UserDetails
        return users.map(UsersInfo::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Override
    public String addUser(Users users) {
        // Encode password before saving the user
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        return "User Added Successfully";
    }
}
