package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.StopDTO;
import com.routebus.demo_spring_boot.model.entity.Stop;
import com.routebus.demo_spring_boot.repository.StopRepository;
import com.routebus.demo_spring_boot.service.StopSerivce;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopServiceImpl implements StopSerivce {
    @Autowired
    StopRepository stopRepostiory;

    @Override
    public void save(StopDTO stopDTO) {
        Stop stop = MapperUtils.convert(stopDTO, Stop.class);
        assert stop != null;
        stopRepostiory.save(stop);
    }

    @Override
    public void delete(Long id) {
        Stop stop = stopRepostiory.findById(id).orElse(null);
        assert stop != null;
        stop.setIsDeleted(true);
        stopRepostiory.save(stop);
    }

    @Override
    public void update(StopDTO stopDTO) {
        Stop stop = MapperUtils.convert(stopDTO, Stop.class);
        assert stop != null;
        stopRepostiory.save(stop);
    }

    @Override
    public List<StopDTO> findAll(Pageable pageable) {
        List<Stop> stop = stopRepostiory.findAll();
        List<StopDTO> stopDTOS = MapperUtils.convertList(stop,StopDTO.class);
        return stopDTOS;
    }

    @Override
    public StopDTO findOne(Long id) {
        Stop stop = stopRepostiory.findById(id).orElse(null);
        return MapperUtils.convert(stop,StopDTO.class);
    }
}
