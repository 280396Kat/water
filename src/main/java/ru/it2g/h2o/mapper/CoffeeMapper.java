package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.coffeeDto.CoffeeDto;
import ru.it2g.h2o.entity.Coffee;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE // игнорируем неизвестные для маппинга поля
)
public interface CoffeeMapper {

    CoffeeDto toDto(Coffee coffee);

    Coffee toEntity(CoffeeDto coffeeDto);
}
