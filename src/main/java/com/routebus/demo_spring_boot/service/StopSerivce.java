package com.routebus.demo_spring_boot.service;

import com.routebus.demo_spring_boot.model.dto.StopDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StopSerivce {
    void save(StopDTO stopDTO);
    void delete(Long id);
    void update(StopDTO stopDTO);
    List<StopDTO> findAll(Pageable pageable);
    StopDTO findOne(Long id);
}
