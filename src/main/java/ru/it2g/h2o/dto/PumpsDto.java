package ru.it2g.h2o.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PumpsDto {

    private Long id;

    private String name;

    private BigDecimal price;

    private String description;

    private Integer vendorCode;

    private String inStock;
}
