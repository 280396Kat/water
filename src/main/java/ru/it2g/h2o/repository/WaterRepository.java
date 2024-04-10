package ru.it2g.h2o.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.it2g.h2o.dto.WaterDto;
import ru.it2g.h2o.entity.Tea;
import ru.it2g.h2o.entity.Water;

import java.math.BigDecimal;
import java.util.List;

public interface WaterRepository extends JpaRepository<Water, Long> {

    @Query(value = "select * from water where is_stock = true AND displacement BETWEEN '0,2' AND '5'", nativeQuery = true)
    List<Water> findAllIsStockUpToFiveLiters();


    @Query(value = "select * from water where is_stock = true AND displacement = 19", nativeQuery = true)
    List<Water> findAllIsStockNineteenLiters();

    @Query(value = "select * from water where is_stock = true", nativeQuery = true)
    List<Water> findWaterInfoByFilter(@Param("categoryId") Long categoryId,
                                  @Param("from") BigDecimal from,
                                  @Param("to") BigDecimal to,
                                  @Param("name") String name,
                                  @Param("vendorCode") Integer vendorCode
    );
}


