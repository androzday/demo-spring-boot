package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.BusRouteDTO;
import com.routebus.demo_spring_boot.model.entity.BusRoute;
import com.routebus.demo_spring_boot.repository.BusRouteRepository;
import com.routebus.demo_spring_boot.service.BusRouteService;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Autowired
    BusRouteRepository busRouteRepostiory;

    @Override
    public void save(BusRouteDTO busRouteDTO) {
        BusRoute busRoute = MapperUtils.convert(busRouteDTO, BusRoute.class);
        assert busRoute != null;
        busRouteRepostiory.save(busRoute);
    }

    @Override
    public void delete(Long id) {
        BusRoute busRoute = busRouteRepostiory.findById(id).orElse(null);
        assert busRoute != null;
        busRoute.setIsDeleted(true);
        busRouteRepostiory.save(busRoute);
    }

    @Override
    public void update(BusRouteDTO busRouteDTO) {
        BusRoute busRoute = MapperUtils.convert(busRouteDTO, BusRoute.class);
        assert busRoute != null;
        busRouteRepostiory.save(busRoute);
    }

    @Override
    public List<BusRouteDTO> findAll(Pageable pageable) {
        List<BusRoute> busRoute = busRouteRepostiory.findAll();
        List<BusRouteDTO> busRouteDTOS = MapperUtils.convertList(busRoute,BusRouteDTO.class);
        return busRouteDTOS;
    }

    @Override
    public BusRouteDTO findOne(Long id) {
        BusRoute busRoute = busRouteRepostiory.findById(id).orElse(null);
        return MapperUtils.convert(busRoute,BusRouteDTO.class);
    }
}
