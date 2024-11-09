package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.teaDto.TeaDto;
import ru.it2g.h2o.entity.Tea;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TeaMapper {

    TeaDto toDto(Tea tea);

    Tea toEntity(TeaDto teaDto);
}
