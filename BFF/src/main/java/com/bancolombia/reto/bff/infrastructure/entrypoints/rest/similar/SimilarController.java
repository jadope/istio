package com.bancolombia.reto.bff.infrastructure.entrypoints.rest.similar;

import com.bancolombia.reto.bff.application.similar.RetrieveSimilarProductUseCase;
import com.bancolombia.reto.bff.infrastructure.entrypoints.rest.shared.TracingHeaders;
import com.bancolombia.reto.bff.infrastructure.entrypoints.rest.similar.response.SimilarResponse;
import com.bancolombia.reto.bff.model.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/goty/similars")
public class SimilarController {
    private final RetrieveSimilarProductUseCase retrieveSimilarProductUseCase;

    @GetMapping("/{id}")
    public List<SimilarResponse> getSimilar(@PathVariable("id") int id, @RequestHeader Map<String, String> headers) {
        var tracingHeaders = TracingHeaders.filterTracingHeaders(headers);
        return retrieveSimilarProductUseCase.retrieveSimilar(id, tracingHeaders)
                .stream()
                .map(this::buildResponse)
                .collect(Collectors.toList());
    }

    private SimilarResponse buildResponse(Product product) {
        return SimilarResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .url(product.getUrl())
                .build();
    }
}
