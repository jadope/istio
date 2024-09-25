package com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.product;

import com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.shared.HeadersConverter;
import com.bancolombia.reto.bff.model.product.Product;
import com.bancolombia.reto.bff.model.product.gateways.ProductConsumerGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductRestConsumerAdapter implements ProductConsumerGateway {
    private final String productsEndpoint;
    private final String productEndpoint;
    private final RestClient restClient;

    public ProductRestConsumerAdapter(@Value("${adapter.restconsumer.backedBaseUrl}") String baseUrl,
                                      @Value("${adapter.restconsumer.products}") String products,
                                      @Value("${adapter.restconsumer.product}") String product,
                                      RestClient restClient) {
        this.productsEndpoint = baseUrl + products;
        this.productEndpoint = baseUrl + product;
        this.restClient = restClient;
    }

    @Override
    public List<Product> getProducts(Map<String, String> trace) {
        return getProductsRequest(trace)
                .stream().map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "getProduct", key = "#idProduct")
    public Product getProduct(int idProduct, Map<String, String> trace) {
        return toModel(getProductRequest(idProduct, trace));
    }

    private List<RequestResponse> getProductsRequest(Map<String, String> headers) {
        return restClient.get()
                .uri(productsEndpoint)
                .headers(HeadersConverter.headersConsumer(headers))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    private RequestResponse getProductRequest(int idProduct, Map<String, String> headers) {
        return restClient.get()
                .uri(productEndpoint, idProduct)
                .headers(HeadersConverter.headersConsumer(headers))
                .exchange((request, response) -> response.bodyTo(RequestResponse.class));
    }

    private Product toModel(RequestResponse response) {
        return Product.builder()
                .id(response.getId())
                .name(response.getName())
                .price(response.getPrice())
                .url(response.getUrl())
                .build();
    }
}
