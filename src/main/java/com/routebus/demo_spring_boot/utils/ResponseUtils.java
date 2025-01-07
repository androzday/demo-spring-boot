package com.routebus.demo_spring_boot.utils;

import com.routebus.demo_spring_boot.common.Response;
import com.routebus.demo_spring_boot.common.ResponseCodeTypeEnum;

public class ResponseUtils {


    public static <T> Response<T> getErrorMessageResponse(String msg) {
        return getResponse(ResponseCodeTypeEnum.FAILED.getCode(),msg);
    }

//    public static <T> Response<T> getResponse(Integer code) {
//        Response<T> response = new Response<T>();
//        response.setCode(code);
//        response.setMessage(Response.RESPONSE_MAP.get(code));
//        return response;
//    }

    public static <T> Response<T> getSuccessResponse(T obj) {

        return getResponse(ResponseCodeTypeEnum.SUCCESS.getCode(),ResponseCodeTypeEnum.SUCCESS.getMessage(),obj);
    }
    public static <T> Response<T> getSuccessResponse() {
        return getSuccessResponse(null);
    }
    public static <T> Response<T> getResponse(Integer code, String msg) {
        return getResponse(code,msg,null);
    }
    public static <T> Response<T> getResponse(Integer code, String msg,T obj) {
        Response<T> response = new Response<T>();
        response.setCode(code);
        response.setMessage(msg);
        response.setResult(obj);
        return response;
    }
}