package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.URI;
@Profile("!local-discovery")
@Component
@ConfigurationProperties(prefix = "spring.thirdParty")
public class InventoryRestTemplateImplemt implements Inventory{
    private  String host;
    private final String InventoryPath= "/api/v1/{beerId}/inventory";
    @Override
    public Integer getOnHandInventory() {
        return null;
    }
}
