package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.RouteDTO;
import com.routebus.demo_spring_boot.model.entity.Route;
import com.routebus.demo_spring_boot.repository.RouteRepostiory;
import com.routebus.demo_spring_boot.service.RouteService;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteRepostiory routeRepostiory;

    @Override
    public void save(RouteDTO routeDTO) {
        Route route = MapperUtils.convert(routeDTO, Route.class);
        assert route != null;
        routeRepostiory.save(route);
    }

    @Override
    public void delete(Long id) {
        Route route = routeRepostiory.findById(id).orElse(null);
        assert route != null;
        route.setIsDeleted(true);
        routeRepostiory.save(route);
    }

    @Override
    public void update(RouteDTO routeDTO) {
        Route route = MapperUtils.convert(routeDTO, Route.class);
        assert route != null;
        routeRepostiory.save(route);
    }

    @Override
    public List<RouteDTO> findAll(Pageable pageable) {
        List<Route> route = routeRepostiory.findAll();
        List<RouteDTO> routeDTOS = MapperUtils.convertList(route,RouteDTO.class);
        return routeDTOS;
    }

    @Override
    public RouteDTO findOne(Long id) {
        Route route = routeRepostiory.findById(id).orElse(null);
        return MapperUtils.convert(route,RouteDTO.class);
    }
}
