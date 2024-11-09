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
import ru.it2g.h2o.dto.coffeeDto.CoffeeDto;
import ru.it2g.h2o.entity.Coffee;
import ru.it2g.h2o.mapper.CoffeeMapper;
import ru.it2g.h2o.repository.CoffeeRepository;

import java.math.BigDecimal;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class CoffeeServiceImplTest {

    @Autowired
    private CoffeeServiceImpl coffeeService;

    @Autowired
    private CoffeeRepository coffeeRepository;


    @Autowired
    private CoffeeMapper coffeeMapper;

    @Before
    public void cleanUp() {
        coffeeRepository.deleteAll();
    }

    @Test
    void getAllIsStockCoffee() {
        CoffeeDto tmp = createCoffeeDto();
        Coffee entity = coffeeMapper.toEntity(tmp);
        coffeeRepository.save(entity);
        List<CoffeeDto> coffeeDtoList = coffeeService.getAllIsStockCoffee();
        Assertions.assertFalse(!CollectionUtils.isEmpty(coffeeDtoList));
    }

    private CoffeeDto createCoffeeDto() {
        return CoffeeDto.builder()
                .name("Арабика. Эфиопия.")
                .price(BigDecimal.valueOf(4500))
                .description("Средняя обжарка. 100% Арабика.")
                .vendorCode(123)
                .inStock("В наличии")
                .build();
    }
}