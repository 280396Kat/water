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
import ru.it2g.h2o.dto.waterDto.WaterDto;
import ru.it2g.h2o.entity.Water;
import ru.it2g.h2o.mapper.WaterMapper;
import ru.it2g.h2o.repository.WaterRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class WaterServiceImplTest {

    @Autowired
    private WaterServiceImpl waterService;

    @Autowired
    private WaterRepository waterRepository;

    @Autowired
    private WaterMapper waterMapper;

    @Before
    public void cleanUp() {
        waterRepository.deleteAll();
    }

    @Test
    void getAllIsStockUpToFiveLiters() {
        WaterDto tmp = waterDto();
        Water entity = waterMapper.toEntity(tmp);
        waterRepository.save(entity);
        List<WaterDto> waterDtoList = waterService.getAllIsStockUpToFiveLiters();
        Assertions.assertFalse(!CollectionUtils.isEmpty(waterDtoList));
    }

    @Test
    void getAllIsStockNineteenLiters() {
        WaterDto tmp = waterDto();
        Water entity = waterMapper.toEntity(tmp);
        waterRepository.save(entity);
        List<WaterDto> waterDtoList = waterService.getAllIsStockNineteenLiters();
        Assertions.assertFalse(!CollectionUtils.isEmpty(waterDtoList));
    }

    private WaterDto waterDto() {
        return WaterDto.builder()
                .name("Вода.")
                .price(BigDecimal.valueOf(450))
                .description("Вода Пилигрим 19 литров.")
                .vendorCode(9988)
                .inStock("В наличии.")
                .build();
    }
}