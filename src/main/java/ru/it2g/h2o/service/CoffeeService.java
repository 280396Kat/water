package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.CoffeeDto;

import java.util.List;

public interface CoffeeService {
    List<CoffeeDto> getAllIsStockCoffee();
}
