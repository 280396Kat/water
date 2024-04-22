package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.waterDto.WaterDto;

import java.util.List;

public interface WaterService {
    List<WaterDto> getAllIsStockUpToFiveLiters();

    List<WaterDto> getAllIsStockNineteenLiters();
}
