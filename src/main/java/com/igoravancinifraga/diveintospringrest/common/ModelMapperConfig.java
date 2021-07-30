package com.igoravancinifraga.diveintospringrest.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean //configure Bean for Instance Injection via Spring
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
