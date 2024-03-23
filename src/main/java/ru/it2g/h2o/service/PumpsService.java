package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.PumpsDto;

import java.util.List;

public interface PumpsService {
    List<PumpsDto> getAllIsStockPumps();
}
