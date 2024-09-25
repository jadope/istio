package com.bancolombia.reto.bff.model.product.gateways;

import com.bancolombia.reto.bff.model.product.Product;

import java.util.List;
import java.util.Map;

public interface ProductConsumerGateway {
    List<Product> getProducts(Map<String, String> trace);

    Product getProduct(int idProduct, Map<String, String> trace);
}
