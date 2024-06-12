package ru.it2g.h2o.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.it2g.h2o.entity.Tea;
import ru.it2g.h2o.repository.TeaRepository;
import ru.it2g.h2o.service.TeaService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class TeaServiceImplTest {

    @Autowired
    private TeaService teaService;
    @Autowired
    private TeaRepository tearRepository;

    @BeforeEach
    void cleanUp() {
        tearRepository.deleteAll();
    }

    @Test
    void saveStockTea() {
        Long teaId = tearRepository.save(createTea()).getId();
        Assertions.assertEquals(teaId, 1l);
    }

    private Tea createTea() {
        return Tea.builder()
                .name("name")
                .build();
    }
}