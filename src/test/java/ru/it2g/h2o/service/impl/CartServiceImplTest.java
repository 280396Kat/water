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
import ru.it2g.h2o.dto.cartDto.CartDto;
import ru.it2g.h2o.dto.cartDto.CartItemDto;
import ru.it2g.h2o.entity.Cart;
import ru.it2g.h2o.entity.User;
import ru.it2g.h2o.mapper.CartMapper;
import ru.it2g.h2o.repository.CartRepository;
import ru.it2g.h2o.repository.UserRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@ActiveProfiles("test")
@SpringBootTest(classes = WaterApplication.class)
@ExtendWith(SpringExtension.class)
class CartServiceImplTest {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void cleanUp() {
        cartRepository.deleteAll();
    }

    @Test
    void addProductsToCart() {
    }

    private CartDto cartDto() {
        return CartDto.builder()
                .success(true)
                .cartItemDto(new CartItemDto())
                .build();
   }

   // создать юзера. создать лист продуктов. сохранить. сделать проверку.
}