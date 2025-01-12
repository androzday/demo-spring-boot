package com.routebus.demo_spring_boot.model.dto;

import com.routebus.demo_spring_boot.model.BaseDTO;
import lombok.Data;

@Data
public class BusDTO extends BaseDTO {
    private Long id;
    private String numberPlate;
    private String type;
    private DriverDTO driver;
}
