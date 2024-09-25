package com.bancolombia.reto.bff.infrastructure.entrypoints.rest.shared;

import java.util.Map;
import java.util.stream.Collectors;

public class TracingHeaders {

    public static final String PREFIX = "x-";

    public static Map<String, String> filterTracingHeaders(Map<String, String> headers) {
        return headers.entrySet()
                .stream()
                .filter(entrySet -> entrySet.getKey().startsWith(PREFIX))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
