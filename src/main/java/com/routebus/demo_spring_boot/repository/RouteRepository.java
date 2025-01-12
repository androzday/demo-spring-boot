package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
}
