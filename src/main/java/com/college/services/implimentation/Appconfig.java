package com.college.services.implimentation;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
     @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
