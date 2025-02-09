package com.routebus.demo_spring_boot.controller;

import com.routebus.demo_spring_boot.model.dto.DriverDTO;
import com.routebus.demo_spring_boot.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DriverGraphQLController {
    @Autowired
    private DriverService driverService;

    @QueryMapping
    public DriverDTO getDriverById(@Argument Long id){
        return driverService.findOne(id);
    }

    @QueryMapping
    public List<DriverDTO> getAllDrivers(){
        return driverService.findAll();
    }


}
