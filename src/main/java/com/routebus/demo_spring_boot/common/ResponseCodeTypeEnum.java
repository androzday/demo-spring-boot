package com.routebus.demo_spring_boot.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ResponseCodeTypeEnum {


    SUCCESS(200, "Permintaan berhasil"),
    FAILED(400, "Permintaan gagal");
    private Integer code;
    private String message;




}