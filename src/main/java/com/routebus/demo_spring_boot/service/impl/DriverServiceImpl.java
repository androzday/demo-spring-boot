package com.routebus.demo_spring_boot.service.impl;

import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import com.routebus.demo_spring_boot.model.entity.Driver;
import com.routebus.demo_spring_boot.service.DriverService;
import com.routebus.demo_spring_boot.repository.DriverRepository;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void save(DriverDTO driverDTO) {
        Driver lastDriver = driverRepository.findTopByOrderByIdDesc();
        Driver driver = MapperUtils.convert(driverDTO, Driver.class);

        assert driver != null;
        if(lastDriver == null){
            driver.setDriverCode("DRV0001");
        }else {
            driver.setDriverCode(generateCodeDriver(lastDriver));
        }
        driverRepository.save(driver);
    }

    @Override
    public void delete(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        assert driver != null;
        driver.setIsDeleted(true);
        driverRepository.save(driver);
    }

    @Override
    public void update(DriverDTO driverDTO) {
        Driver driver = MapperUtils.convert(driverDTO, Driver.class);
        assert driver != null;
        driverRepository.save(driver);
    }

    @Override
    public List<DriverDTO> findAll(Pageable pageable) {
        List<Driver> drivers = driverRepository.findAll();
        List<DriverDTO> driverDTOS = MapperUtils.convertList(drivers,DriverDTO.class);
        return driverDTOS;
    }

    @Override
    public DriverDTO findOne(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        return MapperUtils.convert(driver,DriverDTO.class);
    }
    @Override
    public List<DriverDTO> findAll() {
        List<Driver> drivers = driverRepository.findAll();
        List<DriverDTO> driverDTOS = MapperUtils.convertList(drivers,DriverDTO.class);
        return driverDTOS;
    }
    private String generateCodeDriver(Driver driver){
        String lastCode = driver.getDriverCode();
        String numberPart = lastCode.substring(4);
        int number = Integer.parseInt(numberPart);
        number+=1;

        return "DRV" + String.format("%04d",number);
    }
}
