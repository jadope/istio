package com.bancolombia.reto.bff.application.product;

import com.bancolombia.reto.bff.model.product.Product;
import com.bancolombia.reto.bff.model.product.gateways.ProductConsumerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RetrieveProductsUseCase {
    private final ProductConsumerGateway productConsumerGateway;

    public List<Product> retrieveProducts(Map<String, String> trace) {
        return productConsumerGateway.getProducts(trace);
    }
}
