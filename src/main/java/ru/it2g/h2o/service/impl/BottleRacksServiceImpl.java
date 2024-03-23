package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.BottleRacksDto;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.repository.BottleRacksRepository;
import ru.it2g.h2o.service.BottleRacksService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BottleRacksServiceImpl implements BottleRacksService {

    private final BottleRacksRepository bottleRacksRepository;
    @Override
    public List<BottleRacksDto> getAllIsStockBottleRacks() {
        return bottleRacksRepository.findAllIsStockBottleRacks().stream()
                .map(entity -> BottleRacksDto.builder()
                        .id(entity.getId())
                        .price(entity.getPrice())
                        .inStock(entity.getIsStock() ? "В наличии" : "Нет в наличии")
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .vendorCode(entity.getVendorCode())
                        .build())
                .collect(Collectors.toList());
    }
}
