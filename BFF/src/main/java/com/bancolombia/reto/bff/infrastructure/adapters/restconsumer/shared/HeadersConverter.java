package com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.shared;

import org.springframework.http.HttpHeaders;

import java.util.Map;
import java.util.function.Consumer;

public class HeadersConverter {

    public static Consumer<HttpHeaders> headersConsumer(Map<String, String> headers) {
        return httpHeaders -> {
            headers.forEach(httpHeaders::add);
        };
    }
}
