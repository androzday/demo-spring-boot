package com.routebus.demo_spring_boot.model.dto;

import com.routebus.demo_spring_boot.model.BaseDTO;
import com.routebus.demo_spring_boot.model.entity.Route;
import com.routebus.demo_spring_boot.model.entity.Stop;
import lombok.Data;

@Data
public class RouteStopDTO extends BaseDTO {
    private Long id;
    private Integer stopOrder;
    private RouteDTO route;
    private StopDTO stop;
}
