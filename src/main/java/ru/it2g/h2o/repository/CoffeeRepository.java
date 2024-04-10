package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.entity.Coffee;

import java.math.BigDecimal;
import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    @Query(value = "select * from coffee where is_stock = true", nativeQuery = true)
    List<Coffee> findAllIsStockCoffee();

    @Query(value = "select * from coffee where is_stock = true", nativeQuery = true)
    List<Coffee> findCoffeeInfoByFilter(@Param("categoryId") Long categoryId,
                                              @Param("from") BigDecimal from,
                                              @Param("to") BigDecimal to,
                                              @Param("name") String name,
                                              @Param("vendorCode") Integer vendorCode
    );
}
