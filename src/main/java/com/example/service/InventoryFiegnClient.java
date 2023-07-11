package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name="inventory-service", fallback = InventoryServiceFeignClientFailover.class, configuration = FeignClientConfig.class)
public interface InventoryFiegnClient{
@GetMapping("/api/v1/{beerId}/inventory")
    public Integer getOnHandInventory(@PathVariable UUID beerid);
}
