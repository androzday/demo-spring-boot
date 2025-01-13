package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.RouteDTO;
import com.routebus.demo_spring_boot.model.dto.RouteStopDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RouteStopService {
    void save(RouteStopDTO routeStopDTO);
    void delete(Long id);
    void update(RouteStopDTO routeDTO);
    List<RouteStopDTO> findAll(Pageable pageable);
    RouteStopDTO findOne(Long id);
}
