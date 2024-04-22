package ru.it2g.h2o.service;

import ru.it2g.h2o.dto.coffeeDto.CoffeeDto;

import java.util.List;

public interface CoffeeService {
    List<CoffeeDto> getAllIsStockCoffee();
}
