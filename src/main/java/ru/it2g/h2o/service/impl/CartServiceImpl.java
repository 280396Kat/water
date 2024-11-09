package ru.it2g.h2o.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.it2g.h2o.dto.cartDto.CartDto;
import ru.it2g.h2o.dto.cartDto.CartItemDto;
import ru.it2g.h2o.dto.productItemDto.ProductItemDto;
import ru.it2g.h2o.entity.Cart;
import ru.it2g.h2o.entity.Product;
import ru.it2g.h2o.entity.User;
import ru.it2g.h2o.repository.CartRepository;
import ru.it2g.h2o.repository.ProductRepository;
import ru.it2g.h2o.repository.UserRepository;
import ru.it2g.h2o.service.CartService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final UserRepository userRepository;
    
    private final CartRepository cartRepository;
    
    private final ProductRepository productRepository;

    @Override
    public CartDto addProductsToCart(List<ProductItemDto> productItemDtos) {
        Long userId = getUserId();
        Cart cartEntity = getCart(productItemDtos, userId);
        cartRepository.save(cartEntity);
        CartDto cartDto = new CartDto();
        cartDto.setSuccess(true);
        cartDto.setId(cartEntity.getId());
        CartItemDto cartItemDto = new CartItemDto();
       List<ProductItemDto> products =  cartEntity.getProducts().stream()
                .collect(Collectors.groupingBy(Product::getId, Collectors.summingInt(tmp -> 1)))
                .entrySet().stream()
                .map(tmp -> new ProductItemDto(tmp.getKey(), tmp.getValue()))
                .collect(Collectors.toList());
        cartItemDto.setProductItemDtos(products);
        cartDto.setCartItemDto(cartItemDto);
        return cartDto;
    }

    private Cart getCart(List<ProductItemDto> productItemDtos, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Cart cartEntity = cartRepository.findByUserId(user.getId())
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    return cart;
                });
        cartEntity.getProducts().clear();
        productItemDtos.forEach(productItemDto -> {
            Product product = productRepository.findById(productItemDto.getId())
                    .orElseThrow();
            IntStream.range(0, productItemDto.getCount()).forEach(item -> cartEntity.getProducts().add(product));
        });
        return cartEntity;
    }

    private Long getUserId() { // получаем id юзера из контекста авторизации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userRepository.findByUsername(userDetails.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException()).getId();
        }
        throw new IllegalArgumentException();
    }
}
