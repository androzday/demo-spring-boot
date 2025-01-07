package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepostiory extends JpaRepository<Driver, Long> {
    public Driver findTopByOrderByIdDesc();
}
