package com.bancolombia.reto.bff.model.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private int id;
    private String name;
    private String url;
    private int price;
}
