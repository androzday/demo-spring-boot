package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStopRepository extends JpaRepository<RouteStop, Long> {

}
