package com.routebus.demo_spring_boot.service;


import com.routebus.demo_spring_boot.model.dto.BusDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BusService {
    void save(BusDTO busDTO);
    void delete(Long id);
    void update(BusDTO busDTO);
    List<BusDTO> findAll(Pageable pageable);
    BusDTO findOne(Long id);
}
