package com.routebus.demo_spring_boot.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String message;
    private T result;
    public static final Map<Integer, String> RESPONSE_MAP = new HashMap();
    public Response() {
        this.code = ResponseCodeTypeEnum.SUCCESS.getCode();
        this.message = ResponseCodeTypeEnum.SUCCESS.getMessage();
    }
}