package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.BottleRacksDto;
import ru.it2g.h2o.dto.WaterDto;
import ru.it2g.h2o.repository.WaterRepository;
import ru.it2g.h2o.service.WaterService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WaterServiceImpl implements WaterService {

    private final WaterRepository waterRepository;
    @Override
    public List<WaterDto> getAllIsStockUpToFiveLiters() {
        return waterRepository.findAllIsStockUpToFiveLiters().stream()
                .map(entity -> WaterDto.builder()
                        .id(entity.getId())
                        .price(entity.getPrice())
                        .inStock(entity.getIsStock() ? "В наличии" : "Нет в наличии")
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .vendorCode(entity.getVendorCode())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<WaterDto> getAllIsStockNineteenLiters() {
        return waterRepository.findAllIsStockNineteenLiters().stream()
                .map(entity -> WaterDto.builder()
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
