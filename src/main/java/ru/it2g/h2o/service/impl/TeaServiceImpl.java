package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.repository.TeaRepository;
import ru.it2g.h2o.service.TeaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // посмотреть подробно для чего нужна
public class TeaServiceImpl implements TeaService {

    private final TeaRepository teaRepository;

    @Override
    public List<TeaDto> getAllIsStockTea() {
        return teaRepository.findAllIsStockTea().stream()
                .map(entity -> TeaDto.builder()
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
