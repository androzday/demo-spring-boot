package com.routebus.demo_spring_boot.repository;

import com.routebus.demo_spring_boot.model.entity.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusStopRepository extends JpaRepository<BusStop, Long> {
}
