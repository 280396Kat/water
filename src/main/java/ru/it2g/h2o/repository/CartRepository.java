package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.entity.Cart;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query(value = "select * from cart where is_stock = true", nativeQuery = true)
    List<Cart> findAllIsStockCart();
}
