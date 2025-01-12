package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.BusRouteDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusRouteService {
    void save(BusRouteDTO busRouteDTO);
    void delete(Long id);
    void update(BusRouteDTO busRouteDTO);
    List<BusRouteDTO> findAll(Pageable pageable);
    BusRouteDTO findOne(Long id);
}
