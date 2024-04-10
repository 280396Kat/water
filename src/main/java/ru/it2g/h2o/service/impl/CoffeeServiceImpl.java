package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.CoffeeDto;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.repository.CoffeeRepository;
import ru.it2g.h2o.service.CoffeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public List<CoffeeDto> getAllIsStockCoffee() {
        return coffeeRepository.findAllIsStockCoffee().stream()
                .map(entity -> CoffeeDto.builder()
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
