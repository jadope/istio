package com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.similar;

import com.bancolombia.reto.bff.infrastructure.adapters.restconsumer.shared.HeadersConverter;
import com.bancolombia.reto.bff.model.similar.gateways.SimilarConsumerGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class SimilarRestConsumerAdapter implements SimilarConsumerGateway {
    private final RestClient restClient;
    private final String similarEndpoint;

    public SimilarRestConsumerAdapter(@Value("${adapter.restconsumer.backedBaseUrl}") String baseUrl,
                                      @Value("${adapter.restconsumer.similars}") String similars,
                                      RestClient restClient) {
        this.similarEndpoint = baseUrl + similars;
        this.restClient = restClient;
    }


    @Override
    public List<Integer> getSimilar(int idProduct, Map<String, String> trace) {
        return makeRequest(idProduct, trace);
    }

    private List<Integer> makeRequest(int id, Map<String, String> headers) {
        return restClient.get()
                .uri(similarEndpoint, id)
                .headers(HeadersConverter.headersConsumer(headers))
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
