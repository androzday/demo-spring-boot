package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {

}
