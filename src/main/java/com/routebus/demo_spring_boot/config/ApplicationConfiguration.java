package com.routebus.demo_spring_boot.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objMap = new ObjectMapper();
        objMap.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objMap.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objMap;
    }
}
