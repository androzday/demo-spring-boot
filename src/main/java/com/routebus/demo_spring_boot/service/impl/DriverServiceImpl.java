package com.routebus.demo_spring_boot.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import com.routebus.demo_spring_boot.model.entity.Driver;
import com.routebus.demo_spring_boot.service.DriverService;
import com.routebus.demo_spring_boot.repository.DriverRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepostiory driverRepostiory;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void save(DriverDTO driverDTO) {
        System.out.println("find");
        Driver lastDriver = driverRepostiory.findTopByOrderByIdDesc();
        System.out.println(driverDTO);
        Driver driver = objectMapper.convertValue(driverDTO, Driver.class);

        if(lastDriver == null){
            driver.setDriverCode("DRV0001");
        }else {
            driver.setDriverCode(generateCodeDriver(lastDriver));
        }
        driverRepostiory.save(driver);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(DriverDTO driverDTO) {

    }

    @Override
    public List<DriverDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public DriverDTO findOne(Long id) {
        return objectMapper.convertValue(driverRepostiory.findById(id),DriverDTO.class);
    }

    private String generateCodeDriver(Driver driver){
        String lastCode = driver.getDriverCode();
        String numberPart = lastCode.substring(4);
        int number = Integer.parseInt(numberPart);
        number+=1;

        return "DRV" + String.format("%04d",number);
    }
}
