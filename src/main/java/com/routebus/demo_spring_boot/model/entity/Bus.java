package com.routebus.demo_spring_boot.model.entity;

import com.routebus.demo_spring_boot.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numberPlate;
    private String type;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private Driver driver;
}
