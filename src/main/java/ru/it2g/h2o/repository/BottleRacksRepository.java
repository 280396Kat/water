package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.entity.BottleRacks;
import ru.it2g.h2o.entity.Catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BottleRacksRepository extends JpaRepository<BottleRacks, Long> {
    @Query(value = "select * from bottle_racks where is_stock = true", nativeQuery = true)
    List<BottleRacks> findAllIsStockBottleRacks();

    List<BottleRacks> findBottleRacksInfoByFilter(@Param("categoryId") Long categoryId,
                                              @Param("from") BigDecimal from,
                                              @Param("to") BigDecimal to,
                                              @Param("name") String name,
                                              @Param("vendorCode") Integer vendorCode
    );
}
