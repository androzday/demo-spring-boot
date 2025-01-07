package com.routebus.demo_spring_boot.model.dto;

import lombok.Data;

@Data
public class BusDTO {
    private Long id;
    private String numberPlate;
    private String type;
    private DriverDTO driverDTO;
}
