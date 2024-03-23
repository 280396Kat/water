package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.CatalogFilter;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.repository.*;
import ru.it2g.h2o.service.CatalogService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;
    private final BottleRacksRepository bottleRacksRepository;
    private final CoffeeRepository coffeeRepository;
    private final CupHoldersRepository cupHoldersRepository;
    private final DisposableTablewareRepository disposableTablewareRepository;
    private final PumpsRepository pumpsRepository;
    private final TeaRepository teaRepository;
    private final WaterRepository waterRepository;

    @Override
    public List<?> getInfoCatalogByFilter(CatalogFilter catalogFilter) {
        List<BottleRacks> bottleRacks = bottleRacksRepository.findBottleRacksInfoByFilter(catalogFilter.getCategoryId(),
                catalogFilter.getFrom(),
                catalogFilter.getTo(),
                catalogFilter.getName(),
                catalogFilter.getVendorCode()
        );
        if (isNotEmptyList(bottleRacks)) {
            return bottleRacks;
        }
    }
    
    private boolean isNotEmptyList(List<?> list) {
        if(list.isEmpty()) {
            return false;
        }
        return true;
    }
}