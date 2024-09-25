package com.bancolombia.reto.bff.model.similar.gateways;

import java.util.List;
import java.util.Map;

public interface SimilarConsumerGateway {
    List<Integer> getSimilar(int idProduct, Map<String, String> trace);
}
