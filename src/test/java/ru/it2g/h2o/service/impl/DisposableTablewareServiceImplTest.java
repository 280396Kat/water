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
import ru.it2g.h2o.dto.disposableTablewareDto.DisposableTablewareDto;
import ru.it2g.h2o.entity.DisposableTableware;
import ru.it2g.h2o.mapper.DisposableTablewareMapper;
import ru.it2g.h2o.repository.DisposableTablewareRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class DisposableTablewareServiceImplTest {

    @Autowired
    private DisposableTablewareServiceImpl disposableTablewareService;

    @Autowired
    private DisposableTablewareRepository disposableTablewareRepository;

    @Autowired
    private DisposableTablewareMapper disposableTablewareMapper;

    @Before
    public void cleanUp() {
        disposableTablewareRepository.deleteAll();
    }

    @Test
    void getAllIsStockDisposableTableware() {
        DisposableTablewareDto tmp = disposableTablewareDto();
        DisposableTableware entity = disposableTablewareMapper.toEntity(tmp);
        disposableTablewareRepository.save(entity);
        List<DisposableTablewareDto> disposableTablewareList = disposableTablewareService.getAllIsStockDisposableTableware();
        Assertions.assertFalse(!CollectionUtils.isEmpty(disposableTablewareList));

    }

    private DisposableTablewareDto disposableTablewareDto() {
        return DisposableTablewareDto.builder()
                .name("Одноразовая посуда.")
                .price(BigDecimal.valueOf(100))
                .description("Стаканчики пластиковые 0,2")
                .vendorCode(2707)
                .inStock("В наличии.")
                .build();
    }
}