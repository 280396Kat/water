package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.CupHoldersDto;

import java.util.List;

public interface CupHoldersService {
    List<CupHoldersDto> getAllIsStockCupHolders();
}
