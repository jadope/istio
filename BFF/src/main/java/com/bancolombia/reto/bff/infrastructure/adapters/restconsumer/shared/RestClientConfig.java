package com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient defaultRestClient() {
        return RestClient.builder()
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
