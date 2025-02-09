package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.auth.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
}
