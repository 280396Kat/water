package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.disposableTablewareDto.DisposableTablewareDto;

import java.util.List;

public interface DisposableTablewareService {
    List<DisposableTablewareDto> getAllIsStockDisposableTableware();
}
