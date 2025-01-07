package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DriverService {
    public void save(DriverDTO driverDTO);
    public void delete(Long id);
    public void update(DriverDTO driverDTO);
    public List<DriverDTO> findAll(Pageable pageable);
    public DriverDTO findOne(Long id);
}
