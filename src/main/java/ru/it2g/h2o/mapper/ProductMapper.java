package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.productItemDto.ProductItemDto;
import ru.it2g.h2o.entity.Product;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {

    ProductItemDto toDto(Product product);

    Product toEntity(ProductItemDto productItemDto);
}
