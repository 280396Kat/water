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
import ru.it2g.h2o.dto.teaDto.TeaDto;
import ru.it2g.h2o.entity.Tea;
import ru.it2g.h2o.mapper.TeaMapper;
import ru.it2g.h2o.repository.TeaRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class TeaServiceImplTest {
    @Autowired
    private TeaServiceImpl teaService;

    @Autowired
    private TeaRepository teaRepository;

    @Autowired
    private TeaMapper teaMapper;

    @Before
    public void cleanUp() {
        teaRepository.deleteAll();
    }

    @Test
    void getAllIsStockTea() {
        TeaDto tmp = teaDto();
        Tea entity = teaMapper.toEntity(tmp);
        teaRepository.save(entity);
        List<TeaDto> teaDtoList = teaService.getAllIsStockTea();
        Assertions.assertFalse(!CollectionUtils.isEmpty(teaDtoList));
    }

    private TeaDto teaDto() {
        return TeaDto.builder()
                .name("Чай.")
                .price(BigDecimal.valueOf(1100))
                .description("Чай черный рассыпной Ассам.")
                .vendorCode(2403)
                .inStock("В наличии.")
                .build();
    }
}