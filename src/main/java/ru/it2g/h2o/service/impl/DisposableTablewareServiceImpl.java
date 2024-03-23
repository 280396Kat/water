package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.DisposableTablewareDto;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.repository.DisposableTablewareRepository;
import ru.it2g.h2o.service.DisposableTablewareService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DisposableTablewareServiceImpl implements DisposableTablewareService {

    private final DisposableTablewareRepository disposableTablewareRepository;

    @Override
    public List<DisposableTablewareDto> getAllIsStockDisposableTableware() {
        return disposableTablewareRepository.findAllIsStockDisposableTableware().stream()
                .map(entity -> DisposableTablewareDto.builder()
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
