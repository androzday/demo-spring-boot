package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

 public interface DriverService {
     void save(DriverDTO driverDTO);
     void delete(Long id);
     void update(DriverDTO driverDTO);
     List<DriverDTO> findAll(Pageable pageable);
     List<DriverDTO> findAll();
     DriverDTO findOne(Long id);
}
