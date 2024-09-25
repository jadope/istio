package com.bancolombia.reto.bff.infrastructure.entrypoints.rest.product.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private int id;
    private String name;
    private String url;
    private int price;
}
