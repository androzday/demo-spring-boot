package com.routebus.demo_spring_boot.model.dto;

import lombok.Data;

@Data
public class BusRouteDTO {
    private Long id;
    private BusDTO bus;
    private RouteDTO route;
}
