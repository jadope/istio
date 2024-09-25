package com.bancolombia.reto.bff.infrastructure.entrypoints.rest.similar.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimilarResponse {
    private int id;
    private String name;
    private String url;
    private int price;
}
