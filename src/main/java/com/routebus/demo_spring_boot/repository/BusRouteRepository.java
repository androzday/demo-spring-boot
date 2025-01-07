package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {
}
