package com.routebus.demo_spring_boot.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseDTO {
    private boolean isDeleted;
    private Timestamp createAt;
    private Timestamp updateAt;
}
