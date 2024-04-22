package ru.it2g.h2o.dto.cartDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.it2g.h2o.dto.productItemDto.ProductItemDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartItemDto {

    private List<ProductItemDto> productItemDtos;
}
