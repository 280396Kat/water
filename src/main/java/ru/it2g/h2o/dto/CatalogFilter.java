package ru.it2g.h2o.dto;

import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogFilter {

    private Long categoryId;

    private BigDecimal from;

    private BigDecimal to;

    private String name;

    private Integer vendorCode;

}
