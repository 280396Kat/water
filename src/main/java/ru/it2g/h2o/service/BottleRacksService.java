package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.bottleRacksDto.BottleRacksDto;

import java.util.List;

public interface BottleRacksService {
    List<BottleRacksDto> getAllIsStockBottleRacks();
}
