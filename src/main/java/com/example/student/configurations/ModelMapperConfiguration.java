package com.example.student.configurations;
/*
 * Copyright (c) 2024 Wasif.
 */

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class for Model Mapper
 * It creates a @Bean factory method to create ModelMapper instance
 *
 * @author wasif
 * @version 1.0
 * @since 27/04/24
 */
@Configuration
public class ModelMapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true)// Configure null handling
                .setMatchingStrategy(MatchingStrategies.LOOSE)// Configure matching strategy
                .setAmbiguityIgnored(true);// Configure ambiguity handling
        return modelMapper;
    }
}
