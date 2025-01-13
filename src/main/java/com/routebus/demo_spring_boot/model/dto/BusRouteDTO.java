package com.routebus.demo_spring_boot.model.dto;

import com.routebus.demo_spring_boot.model.BaseDTO;
import lombok.Data;

@Data
public class BusRouteDTO extends BaseDTO {
    private Long id;
    private BusDTO bus;
    private RouteDTO route;
}
