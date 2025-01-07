package com.routebus.demo_spring_boot.model.entity;

import com.routebus.demo_spring_boot.model.BaseEntity;
import com.routebus.demo_spring_boot.utils.DateUtils;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Driver extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String driverCode;
    private String name;


}
