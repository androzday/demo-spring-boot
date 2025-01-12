package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.BusDTO;
import com.routebus.demo_spring_boot.model.entity.Bus;
import com.routebus.demo_spring_boot.repository.BusRepository;
import com.routebus.demo_spring_boot.service.BusService;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    BusRepository busRepostiory;

    @Override
    public void save(BusDTO busDTO) {
        Bus bus = MapperUtils.convert(busDTO, Bus.class);
        assert bus != null;
        busRepostiory.save(bus);
    }

    @Override
    public void delete(Long id) {
        Bus bus = busRepostiory.findById(id).orElse(null);
        assert bus != null;
        bus.setIsDeleted(true);
        busRepostiory.save(bus);
    }

    @Override
    public void update(BusDTO busDTO) {
        Bus bus = MapperUtils.convert(busDTO, Bus.class);
        assert bus != null;
        busRepostiory.save(bus);
    }

    @Override
    public List<BusDTO> findAll(Pageable pageable) {
        List<Bus> bus = busRepostiory.findAll();
        List<BusDTO> busDTOS = MapperUtils.convertList(bus,BusDTO.class);
        return busDTOS;
    }

    @Override
    public BusDTO findOne(Long id) {
        Bus bus = busRepostiory.findById(id).orElse(null);
        return MapperUtils.convert(bus,BusDTO.class);
    }
}
