package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@Builder
public class BeerDTO {

    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;
@JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
@JsonFormat(pattern = "YY-MM-DD")
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
}