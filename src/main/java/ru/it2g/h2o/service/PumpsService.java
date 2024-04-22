package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.pumpsDto.PumpsDto;

import java.util.List;

public interface PumpsService {
    List<PumpsDto> getAllIsStockPumps();
}
