package ru.it2g.h2o.service.impl;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.CollectionUtils;
import ru.it2g.h2o.WaterApplication;
import ru.it2g.h2o.dto.bottleRacksDto.BottleRacksDto;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.repository.BottleRacksRepository;

import java.math.BigDecimal;
import java.util.List;


@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
class BottleRacksServiceImplTest {

    @Autowired
    private BottleRacksServiceImpl bottleRacksService;

    @Autowired
    private BottleRacksRepository bottleRacksRepository;

    @Before
    public void cleanUp() {
        bottleRacksRepository.deleteAll();
    }

    @Test
    void getAllIsStockBottleRacks() {
        BottleRacks tmp = createBottleRacks();
        bottleRacksRepository.save(tmp);
        List<BottleRacksDto> bottleRacksDtoList = bottleRacksService.getAllIsStockBottleRacks();
        Assertions.assertTrue(!CollectionUtils.isEmpty(bottleRacksDtoList));
        Assertions.assertEquals("В наличии", bottleRacksDtoList.get(0).getInStock());
    }

    private BottleRacks createBottleRacks() {
        return BottleRacks.builder()
                .name("Вася")
                .price(BigDecimal.valueOf(13))
                .description("CCC")
                .vendorCode(1)
                .isStock(true)
                .build();
    }
}