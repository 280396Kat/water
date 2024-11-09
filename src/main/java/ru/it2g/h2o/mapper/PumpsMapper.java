package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.pumpsDto.PumpsDto;
import ru.it2g.h2o.entity.Pumps;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PumpsMapper {

    PumpsDto toDto(Pumps pumps);

    Pumps toEntity(PumpsDto pumpsDto);
}
