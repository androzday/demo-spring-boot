package com.routebus.demo_spring_boot.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.routebus.demo_spring_boot.utils.MapperUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration implements InitializingBean {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void afterPropertiesSet() throws Exception {
        MapperUtils.setObjectMapper(objectMapper );
    }
}
