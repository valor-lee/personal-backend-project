package com.valor.product.discovery;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscoveryService {

    private final DiscoveryClient discoveryClient;

    public List getServices() {
        List<String> services = new ArrayList<>();

        discoveryClient.getServices()
                .forEach(serviceId -> {discoveryClient.getInstances(serviceId)
                        .forEach(serviceInstance ->
                                services.add(String.format("%s : %s", serviceId, serviceInstance.getUri())));
                });
        return services;
    }
}
