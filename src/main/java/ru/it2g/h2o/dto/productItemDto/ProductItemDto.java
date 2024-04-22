package ru.it2g.h2o.dto.productItemDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductItemDto {

    private Long id;

    private Integer count;
}
