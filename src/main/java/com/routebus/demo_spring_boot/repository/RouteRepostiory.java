package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepostiory extends JpaRepository<Route, Long> {
}
