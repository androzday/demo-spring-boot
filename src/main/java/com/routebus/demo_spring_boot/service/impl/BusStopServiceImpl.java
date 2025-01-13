package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.BusStopDTO;
import com.routebus.demo_spring_boot.model.entity.BusStop;
import com.routebus.demo_spring_boot.repository.BusStopRepository;
import com.routebus.demo_spring_boot.service.BusStopService;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStopServiceImpl implements BusStopService {
    @Autowired
    BusStopRepository busStopRepostiory;

    @Override
    public void save(BusStopDTO busStopDTO) {
        BusStop busStop = MapperUtils.convert(busStopDTO, BusStop.class);
        assert busStop != null;
        busStopRepostiory.save(busStop);
    }

    @Override
    public void delete(Long id) {
        BusStop busStop = busStopRepostiory.findById(id).orElse(null);
        assert busStop != null;
        busStop.setIsDeleted(true);
        busStopRepostiory.save(busStop);
    }

    @Override
    public void update(BusStopDTO busStopDTO) {
        BusStop busStop = MapperUtils.convert(busStopDTO, BusStop.class);
        assert busStop != null;
        busStopRepostiory.save(busStop);
    }

    @Override
    public List<BusStopDTO> findAll(Pageable pageable) {
        List<BusStop> busStop = busStopRepostiory.findAll();
        List<BusStopDTO> busStopDTOS = MapperUtils.convertList(busStop,BusStopDTO.class);
        return busStopDTOS;
    }

    @Override
    public BusStopDTO findOne(Long id) {
        BusStop busStop = busStopRepostiory.findById(id).orElse(null);
        return MapperUtils.convert(busStop,BusStopDTO.class);
    }
}
