package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.CartDto;
import ru.it2g.h2o.dto.ProductItemDto;

import java.util.List;

public interface CartService {

    CartDto addProductsToCart(List<ProductItemDto> productItemDtos);
}
