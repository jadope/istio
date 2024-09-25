package com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestResponse {
    private int id;
    private String name;
    private String url;
    private int price;
}
