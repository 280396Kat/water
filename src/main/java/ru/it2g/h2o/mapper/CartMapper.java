package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.cartDto.CartDto;
import ru.it2g.h2o.dto.cartDto.CartItemDto;
import ru.it2g.h2o.dto.productItemDto.ProductItemDto;
import ru.it2g.h2o.entity.Cart;
import ru.it2g.h2o.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE // игнорируем неизвестные для маппинга поля
)
public interface CartMapper {

    @Mapping(target = "success", constant = "true")
    @Mapping(target = "cartItemDto", expression = "java(cartItemDto(cart))")
    CartDto toDto(Cart cart);

    Cart toEntity(CartDto cartDto);

    default CartItemDto cartItemDto(Cart cart) {
        CartItemDto cartItemDto = new CartItemDto();
        List<ProductItemDto> products = cart.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getId, Collectors.summingInt(tmp -> 1)))
                .entrySet().stream()
                .map(tmp -> new ProductItemDto(tmp.getKey(), tmp.getValue()))
                .collect(Collectors.toList());
        cartItemDto.setProductItemDtos(products);
        return cartItemDto;
    }
}
