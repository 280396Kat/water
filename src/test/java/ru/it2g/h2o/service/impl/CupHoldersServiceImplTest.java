package ru.it2g.h2o.service.impl;

import liquibase.pro.packaged.B;
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
import ru.it2g.h2o.dto.coffeeDto.CoffeeDto;
import ru.it2g.h2o.dto.cupHoldersDto.CupHoldersDto;
import ru.it2g.h2o.entity.CupHolders;
import ru.it2g.h2o.mapper.CupHoldersMapper;
import ru.it2g.h2o.repository.CupHoldersRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class CupHoldersServiceImplTest {

    @Autowired
    private CupHoldersServiceImpl cupHoldersService;

    @Autowired
    private CupHoldersRepository cupHoldersRepository;

    @Autowired // почему-то разрешает заинжектить только после падения теста
    private CupHoldersMapper cupHoldersMapper;

    @Before
    public void cleanUp() {
        cupHoldersRepository.deleteAll();
    }

    @Test
    void getAllIsStockCupHolders() {
        CupHoldersDto tmp = cupHoldersDto();
        CupHolders entity = cupHoldersMapper.toEntity(tmp);
        cupHoldersRepository.save(entity);
        List<CupHoldersDto> cupHoldersDtoList = cupHoldersService.getAllIsStockCupHolders();
        Assertions.assertFalse(!CollectionUtils.isEmpty(cupHoldersDtoList));

    }

    private CupHoldersDto cupHoldersDto() {
        return CupHoldersDto.builder()
                .name("Стакановержатель на магните.")
                .price(BigDecimal.valueOf(900))
                .description("Вместисость 100 стаканов.")
                .vendorCode(321)
                .inStock("В наличии.")
                .build();
    }
}