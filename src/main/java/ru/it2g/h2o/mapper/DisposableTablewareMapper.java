package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.disposableTablewareDto.DisposableTablewareDto;
import ru.it2g.h2o.entity.DisposableTableware;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE // игнорируем неизвестные для маппинга поля
)
public interface DisposableTablewareMapper {

    DisposableTablewareDto toDto(DisposableTableware disposableTableware);

    DisposableTableware toEntity(DisposableTablewareDto disposableTablewareDto);
}
