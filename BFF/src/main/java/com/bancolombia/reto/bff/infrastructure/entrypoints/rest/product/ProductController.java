package com.bancolombia.reto.bff.infrastructure.entrypoints.rest.product;

import com.bancolombia.reto.bff.application.product.RetrieveProductsUseCase;
import com.bancolombia.reto.bff.infrastructure.entrypoints.rest.shared.TracingHeaders;
import com.bancolombia.reto.bff.model.product.Product;
import com.bancolombia.reto.bff.infrastructure.entrypoints.rest.product.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/goty")
public class ProductController {

    private final RetrieveProductsUseCase retrieveProductsUseCase;

    @GetMapping("/products")
    public List<ProductResponse> getProducts(@RequestHeader Map<String, String> headers) {
        var tracingHeaders = TracingHeaders.filterTracingHeaders(headers);
        return retrieveProductsUseCase.retrieveProducts(tracingHeaders)
                .stream()
                .map(this::buildResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse buildResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .url(product.getUrl())
                .build();
    }
}
