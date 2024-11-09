package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.waterDto.WaterDto;
import ru.it2g.h2o.entity.Water;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface WaterMapper {

    WaterDto toDto(Water water);

    Water toEntity(WaterDto waterDto);
}
