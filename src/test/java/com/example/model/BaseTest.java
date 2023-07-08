package com.example.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {

        @Test
        BeerDTO getBeerDTO() {
            return BeerDTO.builder().beerName("Hi").beerStyle("I dont know")
                    .id(UUID.randomUUID())
                    .createdDate(OffsetDateTime.now())
                    .lastUpdatedDate(OffsetDateTime.now())
                    .price(new BigDecimal("12.99"))
                    .upc(12345678L)
                    .build();
        }

}
