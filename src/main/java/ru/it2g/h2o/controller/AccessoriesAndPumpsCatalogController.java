package ru.it2g.h2o.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.it2g.h2o.dto.BottleRacksDto;
import ru.it2g.h2o.dto.CupHoldersDto;
import ru.it2g.h2o.dto.PumpsDto;
import ru.it2g.h2o.service.BottleRacksService;
import ru.it2g.h2o.service.CupHoldersService;
import ru.it2g.h2o.service.PumpsService;

import java.util.List;

@RestController
@RequestMapping("/accessories-and-pumps-catalog")
@RequiredArgsConstructor
public class AccessoriesAndPumpsCatalogController {

    private final BottleRacksService bottleRacksService;

    private final CupHoldersService cupHoldersService;

    private final PumpsService pumpsService;

    @GetMapping("/bottle-racks")
    public List<BottleRacksDto> getAllIsStockBottleRacks() {
        return bottleRacksService.getAllIsStockBottleRacks();
    }

    @GetMapping("/cup-holder")
    public List<CupHoldersDto> getAllIsStockCupHolders() {
        return cupHoldersService.getAllIsStockCupHolders();
    }

    @GetMapping("/pumps")
    public List<PumpsDto> getAllIsStockPumps() {
        return pumpsService.getAllIsStockPumps();
    }
}
