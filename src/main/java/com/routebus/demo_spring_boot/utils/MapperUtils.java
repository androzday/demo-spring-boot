package com.routebus.demo_spring_boot.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


public final class MapperUtils {


    private static ObjectMapper objectMapper;

    public static void setObjectMapper(ObjectMapper objectMapper) {
        MapperUtils.objectMapper = objectMapper;
    }

    public static <T> List<T> convertList(List<?> sources, Class<T> targetClass) {
        List<T> result = new ArrayList<>();
        for(Object source: sources){
            try {
                result.add(MapperUtils.objectMapper.convertValue(source, targetClass));
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public static <T> T convert(Object source, Class<T> targetClass) {
        try {
            return MapperUtils.objectMapper.convertValue(source, targetClass);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
