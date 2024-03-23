package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.CupHoldersDto;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.repository.CupHoldersRepository;
import ru.it2g.h2o.service.CupHoldersService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CupHoldersServiceImpl implements CupHoldersService {
    private final CupHoldersRepository cupHoldersRepository;

    @Override
    public List<CupHoldersDto> getAllIsStockCupHolders() {
        return cupHoldersRepository.findAllIsStockCupHolders().stream()
                .map(entity -> CupHoldersDto.builder()
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
