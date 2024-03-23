package ru.it2g.h2o.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.it2g.h2o.dto.CoffeeDto;
import ru.it2g.h2o.dto.DisposableTablewareDto;
import ru.it2g.h2o.dto.TeaDto;
import ru.it2g.h2o.dto.WaterDto;
import ru.it2g.h2o.service.CoffeeService;
import ru.it2g.h2o.service.DisposableTablewareService;
import ru.it2g.h2o.service.TeaService;
import ru.it2g.h2o.service.WaterService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final TeaService teaService;
    private final CoffeeService coffeeService;
    private final DisposableTablewareService disposableTablewareService;
    private final WaterService waterService;

    @GetMapping("/teas")
    public List<TeaDto> getAllIsStockTea() {
        return teaService.getAllIsStockTea();
    }

    @GetMapping("/coffee")
    public List<CoffeeDto> getAllIsStockCoffee() {
        return coffeeService.getAllIsStockCoffee();
    }

    @GetMapping("/disposable-tableware")
    public List<DisposableTablewareDto> getAllIsStockDisposableTableware() {
        return disposableTablewareService.getAllIsStockDisposableTableware();
    }

    @GetMapping("/water-up-to-five-liters")
    public List<WaterDto> getAllIsStockUpToFiveLiters() {
        return waterService.getAllIsStockUpToFiveLiters();
    }

    @GetMapping("/water-nineteen-liters")
    public List<WaterDto> getAllIsStockNineteenLiters() {
        return waterService.getAllIsStockNineteenLiters();
    }

    @GetMapping("/water-nineteen-liters")
    public List<?> getInfoCatalogByFilter() {
        return waterService.getAllIsStockNineteenLiters();
    }
}



