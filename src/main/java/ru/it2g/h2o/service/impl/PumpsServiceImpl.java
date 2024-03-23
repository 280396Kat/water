package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.PumpsDto;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.repository.PumpsRepository;
import ru.it2g.h2o.service.PumpsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PumpsServiceImpl implements PumpsService {

    private final PumpsRepository pumpsRepository;

    @Override
    public List<PumpsDto> getAllIsStockPumps() {
        return pumpsRepository.findAllIsStockPumps().stream()
                .map(entity -> PumpsDto.builder()
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
