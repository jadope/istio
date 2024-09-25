package com.bancolombia.reto.bff.application.similar;

import com.bancolombia.reto.bff.model.product.Product;
import com.bancolombia.reto.bff.model.product.gateways.ProductConsumerGateway;
import com.bancolombia.reto.bff.model.similar.gateways.SimilarConsumerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RetrieveSimilarProductUseCase {
    private final SimilarConsumerGateway similarConsumerGateway;
    private final ProductConsumerGateway productConsumerGateway;

    public List<Product> retrieveSimilar(int idProduct, Map<String, String> trace) {
        var similars = similarConsumerGateway.getSimilar(idProduct, trace);
        return similars.stream()
                .map(id -> getProductFromSimilar(id, trace))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Product getProductFromSimilar(int idProduct, Map<String, String> trace) {
        var product = productConsumerGateway.getProduct(idProduct, trace);
        if (product.getName() == null)
            return null;
        return product;
    }
}
