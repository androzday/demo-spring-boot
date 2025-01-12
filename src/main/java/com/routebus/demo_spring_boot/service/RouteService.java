package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import com.routebus.demo_spring_boot.model.dto.RouteDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

 public interface RouteService {
     void save(RouteDTO routeDTO);
     void delete(Long id);
     void update(RouteDTO routeDTO);
     List<RouteDTO> findAll(Pageable pageable);
     RouteDTO findOne(Long id);
}
