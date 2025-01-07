package com.routebus.demo_spring_boot.model.entity;

import com.routebus.demo_spring_boot.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BusRoute extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;




}
