package com.routebus.demo_spring_boot.model.dto;

import lombok.Data;

@Data
public class RouteDTO {
    private Long id;
    private String routeCode;
    private String name;
}
