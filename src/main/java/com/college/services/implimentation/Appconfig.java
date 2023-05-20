package com.college.services.implimentation;

/*
This is configuration class that helps to distinguish configuration which is required to program execution or
 customisation.
 */

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    /*
    ModelMapper bean for easy mapping of Model and Data Transfer Object.
     */
     @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
