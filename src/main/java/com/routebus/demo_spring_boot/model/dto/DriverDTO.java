package com.routebus.demo_spring_boot.model.dto;

import com.routebus.demo_spring_boot.model.BaseDTO;
import lombok.Data;

@Data
public class DriverDTO extends BaseDTO {
    private Long id;
    private String driverCode;
    private String name;
}
