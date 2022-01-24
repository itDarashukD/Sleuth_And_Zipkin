package com.sleuth_AndZipkin.microservice1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MicroserviceController1 {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/microservice1")
    public String method1() {
        logger.info("Inside method 1");

        String baseUrl = "http://localhost:8082/microservice2";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        logger.info("The response receved by method1 is " + response);
        return response;
    }
}
