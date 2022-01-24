package com.sleuth_AndZipkin.microservice1.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig1 {

    @Bean
    RestTemplate getRestTemplate (){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }


}
