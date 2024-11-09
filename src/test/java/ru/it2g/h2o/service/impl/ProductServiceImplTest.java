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
import ru.it2g.h2o.dto.catalogFilter.CatalogFilter;
import ru.it2g.h2o.dto.productItemDto.ProductItemDto;
import ru.it2g.h2o.entity.Product;
import ru.it2g.h2o.mapper.ProductMapper;
import ru.it2g.h2o.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductMapper productMapper;

    @Before
    public void cleanUp() {
        productRepository.deleteAll();
    }

    @Test
    void getInfoCatalogByFilter() {
        ProductItemDto tmp = productItemDto();
        Product entity = productMapper.toEntity(tmp);
        productRepository.save(entity);
        List<?> productItemDtosList = productService.getInfoCatalogByFilter(new CatalogFilter());
        Assertions.assertFalse(!CollectionUtils.isEmpty(productItemDtosList));

    }

    private ProductItemDto productItemDto() {
       return ProductItemDto.builder()
               .count(6)
               .build();
    }
}