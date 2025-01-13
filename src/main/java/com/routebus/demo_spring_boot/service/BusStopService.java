package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.BusStopDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusStopService {
    void save(BusStopDTO busStopDTO);
    void delete(Long id);
    void update(BusStopDTO busStopDTO);
    List<BusStopDTO> findAll(Pageable pageable);
    BusStopDTO findOne(Long id);
}
