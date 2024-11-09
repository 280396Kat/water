package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.bottleRacksDto.BottleRacksDto;
import ru.it2g.h2o.entity.BottleRacks;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE // игнорируем неизвестные для маппинга поля
)
public interface BottleRacksMapper {

    @Mapping(target = "inStock", expression = "java(mapIsStock(bottleRacks.getIsStock()))")
    BottleRacksDto toDto(BottleRacks bottleRacks);

    BottleRacks toEntity(BottleRacksDto bottleRacksDto);

    //@Mapping(target = "inStock", expression = "java(mapIsStock(bottleRacks.getIsStock()))")
    List<BottleRacksDto> toDto(List<BottleRacks> bottleRacks);

    default String mapIsStock(boolean isStock) {
        return isStock ? "В наличии"  : "Нет в наличии";
    }
}