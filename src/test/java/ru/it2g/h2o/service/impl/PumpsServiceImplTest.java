package ru.it2g.h2o.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.CollectionUtils;
import ru.it2g.h2o.WaterApplication;
import ru.it2g.h2o.dto.pumpsDto.PumpsDto;
import ru.it2g.h2o.entity.Pumps;
import ru.it2g.h2o.mapper.PumpsMapper;
import ru.it2g.h2o.repository.PumpsRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class PumpsServiceImplTest {
    @Autowired
    private PumpsServiceImpl pumpsService;

    @Autowired
    private PumpsRepository pumpsRepository;

    @Autowired
    private PumpsMapper pumpsMapper;

    @Before
    public void cleanUp() {
        pumpsRepository.deleteAll();
    }

    @Test
    void getAllIsStockPumps() {
        PumpsDto tmp = pumpsDto();
        Pumps entity = pumpsMapper.toEntity(tmp);
        pumpsRepository.save(entity);
        List<PumpsDto> pumpsDtoList = pumpsService.getAllIsStockPumps();
        Assertions.assertFalse(!CollectionUtils.isEmpty(pumpsDtoList));
    }

    private PumpsDto pumpsDto() {
        return PumpsDto.builder()
                .name("Помпа.")
                .price(BigDecimal.valueOf(1800))
                .description("Помпа электрическая.")
                .vendorCode(2803)
                .inStock("В наличии.")
                .build();
    }
}