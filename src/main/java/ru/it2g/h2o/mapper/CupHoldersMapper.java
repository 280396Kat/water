package ru.it2g.h2o.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.it2g.h2o.dto.cupHoldersDto.CupHoldersDto;
import ru.it2g.h2o.entity.CupHolders;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE // игнорируем неизвестные для маппинга поля
)
public interface CupHoldersMapper {

    CupHoldersDto toDto(CupHolders cupHolders);

    CupHolders toEntity(CupHoldersDto cupHoldersDto);
}
