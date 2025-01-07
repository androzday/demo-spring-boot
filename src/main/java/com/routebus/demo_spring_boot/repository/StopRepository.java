package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop, Long> {
}