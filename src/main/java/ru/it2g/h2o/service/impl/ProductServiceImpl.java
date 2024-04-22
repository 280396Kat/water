package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.catalogFilter.CatalogFilter;
import ru.it2g.h2o.entity.*;
import ru.it2g.h2o.repository.*;
import ru.it2g.h2o.service.ProductService;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository catalogRepository;
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

        List<Coffee> coffees = coffeeRepository.findCoffeeInfoByFilter(catalogFilter.getCategoryId(),
                catalogFilter.getFrom(),
                catalogFilter.getTo(),
                catalogFilter.getName(),
                catalogFilter.getVendorCode()
        );
        if (isNotEmptyList(coffees)) {
            return coffees;
        }

        List<CupHolders> cupHolders = cupHoldersRepository.findCupHoldersInfoByFilter(catalogFilter.getCategoryId(),
                catalogFilter.getFrom(),
                catalogFilter.getTo(),
                catalogFilter.getName(),
                catalogFilter.getVendorCode()
        );
        if (isNotEmptyList(cupHolders)) {
            return cupHolders;
        }

        List<DisposableTableware> disposableTablewares = disposableTablewareRepository.
                findDisposableTablewareInfoByFilter(catalogFilter.getCategoryId(),
                catalogFilter.getFrom(),
                catalogFilter.getTo(),
                catalogFilter.getName(),
                catalogFilter.getVendorCode()
        );
        if (isNotEmptyList(disposableTablewares)) {
            return disposableTablewares;
        }

        List<Pumps> pumps = pumpsRepository.findPumpsInfoByFilter(catalogFilter.getCategoryId(),
                        catalogFilter.getFrom(),
                        catalogFilter.getTo(),
                        catalogFilter.getName(),
                        catalogFilter.getVendorCode()
                );
        if (isNotEmptyList(pumps)) {
            return pumps;
        }

        List<Tea> teas = teaRepository.findTeaInfoByFilter(catalogFilter.getCategoryId(),
                        catalogFilter.getFrom(),
                        catalogFilter.getTo(),
                        catalogFilter.getName(),
                        catalogFilter.getVendorCode()
                );
        if (isNotEmptyList(teas)) {
            return teas;
        }

        List<Water> waters = waterRepository.findWaterInfoByFilter(catalogFilter.getCategoryId(),
                catalogFilter.getFrom(),
                catalogFilter.getTo(),
                catalogFilter.getName(),
                catalogFilter.getVendorCode()
        );
        if (isNotEmptyList(waters)) {
            return waters;
        }
        return new ArrayList<>();
    }
    
    private boolean isNotEmptyList(List<?> list) {
        if(list.isEmpty()) {
            return false;
        }
        return true;
    }
}