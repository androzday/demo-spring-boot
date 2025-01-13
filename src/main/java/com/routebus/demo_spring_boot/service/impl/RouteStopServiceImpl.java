package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.RouteStopDTO;
import com.routebus.demo_spring_boot.model.entity.RouteStop;
import com.routebus.demo_spring_boot.repository.RouteStopRepository;
import com.routebus.demo_spring_boot.service.RouteStopService;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteStopServiceImpl implements RouteStopService {
    @Autowired
    RouteStopRepository routeStopRepository;

    @Override
    public void save(RouteStopDTO routeStopDTO) {
        RouteStop routeStop = MapperUtils.convert(routeStopDTO, RouteStop.class);
        assert routeStop != null;
        routeStopRepository.save(routeStop);
    }

    @Override
    public void delete(Long id) {
        RouteStop routeStop = routeStopRepository.findById(id).orElse(null);
        assert routeStop != null;
        routeStop.setIsDeleted(true);
        routeStopRepository.save(routeStop);
    }

    @Override
    public void update(RouteStopDTO routeStopDTO) {
        RouteStop routeStop = MapperUtils.convert(routeStopDTO, RouteStop.class);
        assert routeStop != null;
        routeStopRepository.save(routeStop);
    }

    @Override
    public List<RouteStopDTO> findAll(Pageable pageable) {
        List<RouteStop> routeStop = routeStopRepository.findAll();
        List<RouteStopDTO> routeStopDTOS = MapperUtils.convertList(routeStop,RouteStopDTO.class);
        return routeStopDTOS;
    }

    @Override
    public RouteStopDTO findOne(Long id) {
        RouteStop routeStop = routeStopRepository.findById(id).orElse(null);
        return MapperUtils.convert(routeStop,RouteStopDTO.class);
    }
}
